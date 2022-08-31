package com.rocs.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rocs.common.utils.PageUtils;
import com.rocs.gulimall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 15:24:05
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

