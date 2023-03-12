package com.rocs.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.rocs.gulimall.product.vo.AttrResponseVo;
import com.rocs.gulimall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rocs.gulimall.product.entity.AttrEntity;
import com.rocs.gulimall.product.service.AttrService;
import com.rocs.common.utils.PageUtils;
import com.rocs.common.utils.R;


/**
 * 商品属性
 *
 * @author rocsmytune
 * @email m.shi@student.tue.nl
 * @date 2022-08-31 14:43:19
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @GetMapping("/base/list/{catelogId}")
    //@RequiresPermissions("product:attr:base:list")
    public  R baseAttrList(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId) {

        PageUtils page = attrService.queryBaseAttrPage(params, catelogId);
        return R.ok().put("page",page);

    }

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    //@RequiresPermissions("product:attr:list")
//    public R list(@RequestParam Map<String, Object> params) {
//        PageUtils page = attrService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId) {
//        AttrEntity attr = attrService.getById(attrId);

        AttrResponseVo attrResponseVo = attrService.getAttrInfo(attrId);
        return R.ok().put("attr", attrResponseVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr) {
        attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr) {
        attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
