package com.rocs.gulimall.ware.dao;

import com.rocs.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 15:31:39
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
