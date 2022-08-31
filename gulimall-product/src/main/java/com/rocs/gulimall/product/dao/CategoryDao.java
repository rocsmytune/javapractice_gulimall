package com.rocs.gulimall.product.dao;

import com.rocs.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 14:43:19
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
