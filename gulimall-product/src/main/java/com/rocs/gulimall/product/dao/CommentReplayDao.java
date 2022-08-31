package com.rocs.gulimall.product.dao;

import com.rocs.gulimall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 14:43:19
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
