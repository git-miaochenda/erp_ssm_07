package com.erp.test;

import com.erp.mapper.GoodsMapper;
import com.erp.pojo.Goods;
import com.erp.pojo.GoodsExample;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperTest {
    @Test
    public void testSelect() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        GoodsMapper goodsMapper = ctx.getBean("goodsMapper", GoodsMapper.class);
        System.out.println(goodsMapper);
        //使用条件查询 设置条件
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        //使用善品名称进行模糊查询 只代表用了like关键字 还得需要%%
        criteria.andNameLike("%空%");
        List<Goods> goods = goodsMapper.selectByExample(example);
        System.out.println(goods);
    }
}
