package com.fan.mybatisplus;

import com.fan.mybatisplus.mapper.ProductMapper;
import com.fan.mybatisplus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusTestLock {

    @Autowired
    ProductMapper productMapper;

    @Test
    void testOptimisticLock(){
        Product pLi = productMapper.selectById(1L);
        System.out.println("小李取出商品的价格"+pLi.getPrice());

        Product pWang =productMapper.selectById(1L);
        System.out.println("小王取出商品价格是："+pWang.getPrice());

        pLi.setPrice(pLi.getPrice()+50);
        productMapper.updateById(pLi);
        System.out.println("小李修改后的价格是："+pLi.getPrice());

        pWang.setPrice(pWang.getPrice()-30);
        int result = productMapper.updateById(pWang);
        if (result == 0){
            pWang = productMapper.selectById(1L);
            pWang.setPrice(pWang.getPrice()-30);
            productMapper.updateById(pWang);
        }
        System.out.println("小王修改的价格是"+pWang.getPrice());

        Product pBoss = productMapper.selectById(1L);
        System.out.println("老板查询的价格是："+pBoss.getPrice());
    }
}
