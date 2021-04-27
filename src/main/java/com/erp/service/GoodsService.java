package com.erp.service;

import com.erp.pojo.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> selectByExample(Goods goods,int pageNum,int pageSize );
}
