package com.example.MallManageSystem.service.impl;

import com.example.MallManageSystem.dao.entity.OrderDO;
import com.example.MallManageSystem.dao.mapper.*;
import com.example.MallManageSystem.dto.req.stat.ConsumptionOfUserStatReqDTO;
import com.example.MallManageSystem.dto.req.stat.SaleOfProductStatReqDTO;
import com.example.MallManageSystem.dto.resp.stat.ConsumptionOfUserStatRespDTO;
import com.example.MallManageSystem.dto.resp.stat.SaleOfProductStatRespDTO;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StatServiceImpl implements StatService {
    private final UserMapper userMapper;
    private final SellerMapper sellerMapper;
    private final ProductMapper productMapper;
    private final ProductItemMapper productItemMapper;
    private final OrderMapper orderMapper;

    @Override
    public ConsumptionOfUserStatRespDTO consumptionOfUserStat(ConsumptionOfUserStatReqDTO reqDTO) throws MallException {
        if (userMapper.selectById(reqDTO.getUserId()) == null) {
            throw MallException.builder()
                    .message("该用户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }

        List<OrderDO> list = orderMapper.selectByUserId(reqDTO.getUserId());
        Double sum = 0d;
        for (OrderDO orderDO : list) {
            sum += orderDO.getPayAmount();
        }

        return ConsumptionOfUserStatRespDTO.builder()
                .orderCount(list.size())
                .totalAmount(sum)
                .build();
    }

    @Override
    public SaleOfProductStatRespDTO saleOfProductStat(SaleOfProductStatReqDTO reqDTO) throws MallException {
        if (productMapper.selectById(reqDTO.getProductId()) == null) {
            throw MallException.builder()
                    .message("该产品不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }

        List<OrderDO> list = orderMapper.selectByProductId(reqDTO.getProductId());
        Double sum = 0d;
        for (OrderDO orderDO : list) {
            sum += orderDO.getPayAmount();
        }

        return SaleOfProductStatRespDTO.builder()
                .orderCount(list.size())
                .totalAmount(sum)
                .build();
    }
}
