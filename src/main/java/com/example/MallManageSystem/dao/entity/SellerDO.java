package com.example.MallManageSystem.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("sellers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerDO extends BaseDO{
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String introduction;
}
