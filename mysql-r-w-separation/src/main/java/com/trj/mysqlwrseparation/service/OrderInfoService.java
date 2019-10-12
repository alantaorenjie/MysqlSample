package com.trj.mysqlwrseparation.service;

import com.trj.mysqlwrseparation.mapper.OrderInfoMapper;
import com.trj.mysqlwrseparation.mapper.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author TRJ
 * @date 2019/10/11
 * Description:
 */
@Slf4j
@Service
public class OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    public void mix(){
        log.info("开始mix");
        OrderInfo orderInfo;

        log.info("开始查询");
        orderInfo = orderInfoMapper.selectByPrimaryKey(10L);
        log.info("查询结果： {}",orderInfo==null?"null fsdfasd":orderInfo.toString());

        orderInfo = new OrderInfo();
        orderInfo.setOrderId(System.currentTimeMillis());
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        log.info("开始插入数据");
        orderInfoMapper.insert(orderInfo);

        log.info("开始查询");
        orderInfo = orderInfoMapper.selectByPrimaryKey(10L);
        log.info("查询结果： {}",orderInfo==null?"null fsdfasd":orderInfo.toString());
    }

}
