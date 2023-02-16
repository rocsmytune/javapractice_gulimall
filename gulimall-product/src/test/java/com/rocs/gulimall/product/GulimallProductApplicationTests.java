package com.rocs.gulimall.product;

import com.rocs.gulimall.product.entity.BrandEntity;
import com.rocs.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

//    @Autowired
//    OSSClient ossClient;

//    @Test
//    public void testUpload() throws FileNotFoundException {
//        OSS oss
//    }

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("LG公司");
        brandService.updateById(brandEntity);
        System.out.println("成功！！！");
    }

}
