package com.example.MallManageSystem.dao.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

@Data
public class BaseDO {
    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer isDeleted;
}

