package com.erp.controller;

import com.erp.pojo.Goods;
import com.erp.service.GoodsService;
import com.erp.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/list")
    public List<Goods> selectByExample(Goods goods,
                                       @RequestParam(defaultValue = "1") int pageName,
                                       @RequestParam(defaultValue = "2") int pageSize){
        return goodsService.selectByExample(goods, pageName, pageSize);
    }
}
