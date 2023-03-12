package com.rocs.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rocs.common.utils.PageUtils;
import com.rocs.gulimall.product.entity.AttrEntity;
import com.rocs.gulimall.product.vo.AttrResponseVo;
import com.rocs.gulimall.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 14:43:19
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId);

    AttrResponseVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);
}

