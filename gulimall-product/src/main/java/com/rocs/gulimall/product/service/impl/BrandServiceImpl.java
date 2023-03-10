package com.rocs.gulimall.product.service.impl;

import com.mysql.cj.util.StringUtils;
import com.rocs.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rocs.common.utils.PageUtils;
import com.rocs.common.utils.Query;

import com.rocs.gulimall.product.dao.BrandDao;
import com.rocs.gulimall.product.entity.BrandEntity;
import com.rocs.gulimall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmptyOrWhitespaceOnly(key)) {
            queryWrapper.eq("brand_id", key).or().like("name",key);
        }

        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void updateDetails(BrandEntity brand) {
        //保证字段数据一致
        this.updateById(brand);

        if (!StringUtils.isEmptyOrWhitespaceOnly(brand.getName())) {
            //同步更新其他关联表
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());

            //TODO update other associated info
        }

    }

}