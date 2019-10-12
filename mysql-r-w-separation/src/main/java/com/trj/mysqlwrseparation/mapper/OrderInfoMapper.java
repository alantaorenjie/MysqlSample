package com.trj.mysqlwrseparation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trj.mysqlwrseparation.mapper.entity.OrderInfo;

public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}