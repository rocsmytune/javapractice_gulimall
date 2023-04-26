package com.rocs.gulimall.ware.service.impl;

import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rocs.common.utils.PageUtils;
import com.rocs.common.utils.Query;

import com.rocs.gulimall.ware.dao.WareInfoDao;
import com.rocs.gulimall.ware.entity.WareInfoEntity;
import com.rocs.gulimall.ware.service.WareInfoService;


@Service("wareInfoService")
public class WareInfoServiceImpl extends ServiceImpl<WareInfoDao, WareInfoEntity> implements WareInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Object key = params.get("key");
        QueryWrapper<WareInfoEntity> wrapper = new QueryWrapper<>();
        if (!StringUtils.isNullOrEmpty(key.toString())) {
            wrapper.and((obj) -> {
                obj.eq("id", key).or()
                        .like("name", key)
                        .or().like("address", key)
                        .or().like("areacode", key);
            });
        }

        IPage<WareInfoEntity> page = this.page(
                new Query<WareInfoEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}