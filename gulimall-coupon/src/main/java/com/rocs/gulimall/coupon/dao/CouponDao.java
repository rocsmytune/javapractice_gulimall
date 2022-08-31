package com.rocs.gulimall.coupon.dao;

import com.rocs.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 15:17:06
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
