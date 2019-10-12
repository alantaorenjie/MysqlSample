package com.trj.mysqlwrseparation;

import com.trj.mysqlwrseparation.mapper.OrderInfoMapper;
import com.trj.mysqlwrseparation.mapper.entity.OrderInfo;
import com.trj.mysqlwrseparation.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 测试内容如下：
 * 1、读写分离事务，事务中一旦有写操作，之后所有的操作都在master中进行
 * 2、强制使用master
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlWRSeparationApplicationTests {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    OrderInfoService orderInfoService;

    @Test
    public void insert() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(System.currentTimeMillis());
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        log.info("开始插入数据");
        orderInfoMapper.insert(orderInfo);
    }

    @Test
    public void query() {
        log.info("开始查询");
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(1L);
        log.info("查询结果： {}", orderInfo.toString());
    }

    @Test
    public void mix() {
        log.info("开始mix");
        insert();
        query();
    }

    @Test
    public void mixTx() {
        orderInfoService.mix();
    }

    @Test
    public void forceMaster() {
        //此时应该是走slave
        query();

        //设置强制走master
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();

        //此时应该走master
        query();

        //业务结束后需要清除标识
        HintManager.clear();
    }

}
