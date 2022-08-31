package com.rocs.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rocs.common.utils.PageUtils;
import com.rocs.gulimall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 15:24:05
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

