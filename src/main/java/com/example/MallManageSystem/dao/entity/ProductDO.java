package com.example.MallManageSystem.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDO extends BaseDO{
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer sellerId;

    private Integer categoryId;

    private String name;

    private String introduction;
}
