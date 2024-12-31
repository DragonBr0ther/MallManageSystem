package com.example.MallManageSystem.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.MallManageSystem.dao.entity.UserDO;

import java.util.List;

public interface UserMapper extends BaseMapper<UserDO> {
    default List<UserDO> selectListByAccount(String account){
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        return this.selectList(queryWrapper);
    }
}
