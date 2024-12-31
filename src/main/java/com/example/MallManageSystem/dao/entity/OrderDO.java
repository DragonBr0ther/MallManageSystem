package com.example.MallManageSystem.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDO extends BaseDO{
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer userAddressId;

    private Integer productId;

    private Integer productItemId;

    private Integer quantity;

    private Double price;

    private Double payAmount;

    private Integer isPaid;

    private Integer isCompleted;

}
