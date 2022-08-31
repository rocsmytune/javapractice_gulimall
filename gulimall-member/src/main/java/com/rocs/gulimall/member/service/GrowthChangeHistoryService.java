package com.rocs.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rocs.common.utils.PageUtils;
import com.rocs.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 15:24:05
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

