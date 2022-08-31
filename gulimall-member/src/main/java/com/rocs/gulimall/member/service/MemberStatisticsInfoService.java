package com.rocs.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rocs.common.utils.PageUtils;
import com.rocs.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 15:24:05
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

