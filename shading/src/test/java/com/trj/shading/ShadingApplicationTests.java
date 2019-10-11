package com.trj.shading;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trj.shading.mapper.OrderInfoMapper;
import com.trj.shading.mapper.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShadingApplicationTests {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setUserId(i + 1L);
            orderInfo.setOrderId(System.currentTimeMillis());
            orderInfo.setCreateTime(new Date());
            orderInfo.setUpdateTime(new Date());
            orderInfoMapper.insert(orderInfo);
        }
    }

    @Test
    public void query() {
        log.info("开始查询");
        OrderInfo orderInfo = orderInfoMapper.selectOne(new QueryWrapper<OrderInfo>().lambda().eq(OrderInfo::getUserId,1L));
        log.info("结果查询： {}", orderInfo == null ? "数据为空" : orderInfo.toString());
    }

}
