package com.rocs.gulimall.product.service.impl;

import com.mysql.cj.util.StringUtils;
import com.rocs.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.rocs.gulimall.product.dao.AttrGroupDao;
import com.rocs.gulimall.product.dao.CategoryDao;
import com.rocs.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.rocs.gulimall.product.entity.AttrGroupEntity;
import com.rocs.gulimall.product.entity.CategoryEntity;
import com.rocs.gulimall.product.vo.AttrResponseVo;
import com.rocs.gulimall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rocs.common.utils.PageUtils;
import com.rocs.common.utils.Query;

import com.rocs.gulimall.product.dao.AttrDao;
import com.rocs.gulimall.product.entity.AttrEntity;
import com.rocs.gulimall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    AttrAttrgroupRelationDao relationDao;
    @Autowired
    AttrGroupDao groupDao;
    @Autowired
    CategoryDao categoryDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveAttr(AttrVo attr) {
        //保存基本数据
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity); //将vo的值赋到po里
        this.save(attrEntity);

        //保存关联关系
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
        attrAttrgroupRelationEntity.setAttrId(attr.getAttrId());

        relationDao.insert(attrAttrgroupRelationEntity);

    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();

        if (catelogId != 0) {
            queryWrapper.eq("catelog_id",catelogId);
        }

        String key = (String) params.get("key");
        if (!StringUtils.isEmptyOrWhitespaceOnly(key)) {
            queryWrapper.and((wrapper) ->{
                wrapper.eq("attr_id", key).or().like("attr_name", key);
            });
        }

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );

        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrResponseVo> responseVos = records.stream().map((attrEntity -> {
            AttrResponseVo attrResponseVo = new AttrResponseVo();
            BeanUtils.copyProperties(attrEntity, attrResponseVo);

            //设置分类和分组名字
            AttrAttrgroupRelationEntity attr_id = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrEntity.getAttrId()));
            if (attr_id != null) {
                AttrGroupEntity attrGroupEntity = groupDao.selectById(attr_id.getAttrGroupId());
                attrResponseVo.setGroupName(attrGroupEntity.getAttrGroupName());
            }

            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrResponseVo.setCatelogName(categoryEntity.getName());
            }
            return attrResponseVo;

        })).collect(Collectors.toList());

        pageUtils.setList(responseVos);

        return  pageUtils;
    }

}