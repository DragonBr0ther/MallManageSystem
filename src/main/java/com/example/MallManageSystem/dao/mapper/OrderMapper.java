package com.example.MallManageSystem.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.MallManageSystem.dao.entity.OrderDO;
import java.util.List;

public interface OrderMapper extends BaseMapper<OrderDO> {
    default List<OrderDO> selectByUserId(Integer userId){
        QueryWrapper<OrderDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.selectList(queryWrapper);
    }
    default List<OrderDO> selectByProductId(Integer productId){
        QueryWrapper<OrderDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);
        return this.selectList(queryWrapper);
    }
}
