package com.trj.mysqlwrseparation.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 订单表
 */
@Data
@TableName(value = "order_info")
public class OrderInfo {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Date createTime;

    private Date updateTime;
}