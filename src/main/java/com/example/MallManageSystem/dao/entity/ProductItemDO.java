package com.example.MallManageSystem.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("product_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItemDO extends BaseDO{
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer productId;

    private Integer stockQuantity;

    private Double price;

    private String description;
}
