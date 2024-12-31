package com.example.MallManageSystem.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.MallManageSystem.dao.entity.SellerDO;

import java.util.List;

public interface SellerMapper extends BaseMapper<SellerDO> {
    default List<SellerDO> selectListByAccount(String account){
        QueryWrapper<SellerDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        return this.selectList(queryWrapper);
    }
}
