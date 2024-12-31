package com.example.MallManageSystem.service.impl;

import com.example.MallManageSystem.dao.entity.OrderDO;
import com.example.MallManageSystem.dao.entity.ProductItemDO;
import com.example.MallManageSystem.dao.mapper.*;
import com.example.MallManageSystem.dto.req.order.*;
import com.example.MallManageSystem.dto.resp.order.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.Null;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ProductItemMapper productItemMapper;

    @Override
    public PlaceOrderRespDTO placeOrder(PlaceOrderReqDTO reqDTO) throws MallException {
        if (userMapper.selectById(reqDTO.getUserId()) == null) {
            throw MallException.builder()
                    .message("该用户不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (productMapper.selectById(reqDTO.getProductId()) == null) {
            throw MallException.builder()
                    .message("该产品不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }

        ProductItemDO productItemDO = productItemMapper.selectById(reqDTO.getProductItemId());
        if (productItemDO == null) {
            throw MallException.builder()
                    .message("该产品分类不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (productItemDO.getStockQuantity() < reqDTO.getQuantity()) {
            throw MallException.builder()
                    .message("该产品库存不足")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }

        productItemDO.setStockQuantity(productItemDO.getStockQuantity() - reqDTO.getQuantity());
        productItemMapper.updateById(productItemDO);

        OrderDO orderDO = OrderDO.builder()
                .userId(reqDTO.getUserId())
                .userAddressId(reqDTO.getUserAddressId())
                .productId(reqDTO.getProductId())
                .productItemId(reqDTO.getProductItemId())
                .quantity(reqDTO.getQuantity())
                .price(productItemDO.getPrice())
                .payAmount(productItemDO.getPrice() * reqDTO.getQuantity())
                .build();
        orderMapper.insert(orderDO);

        return PlaceOrderRespDTO.builder()
                .payAmount(productItemDO.getPrice() * reqDTO.getQuantity())
                .build();
    }

    @Override
    public PayOrderRespDTO payOrder(PayOrderReqDTO reqDTO) throws MallException {
        OrderDO orderDO = orderMapper.selectById(reqDTO.getId());
        if (orderDO == null) {
            throw MallException.builder()
                    .message("该订单不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (orderDO.getIsCompleted() != 0) {
            throw MallException.builder()
                    .message("该订单已完成或取消")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (orderDO.getIsPaid() != 0) {
            throw MallException.builder()
                    .message("该订单已支付")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        orderDO.setIsPaid(1);
        orderMapper.updateById(orderDO);
        return null;
    }

    @Override
    public CancelOrderRespDTO cancelOrder(CancelOrderReqDTO reqDTO) throws MallException {
        OrderDO orderDO = orderMapper.selectById(reqDTO.getId());
        if (orderDO == null) {
            throw MallException.builder()
                    .message("该订单不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (orderDO.getIsCompleted() != 0) {
            throw MallException.builder()
                    .message("该订单已完成或取消")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }

        ProductItemDO productItemDO = productItemMapper.selectById(orderDO.getProductItemId());
        if (productItemDO == null) {
            throw MallException.builder()
                    .message("该订单信息错误")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        productItemDO.setStockQuantity(productItemDO.getStockQuantity() + orderDO.getQuantity());
        productItemMapper.updateById(productItemDO);

        orderDO.setIsCompleted(-1);
        orderMapper.updateById(orderDO);

        return null;
    }

    @Override
    public CompleteOrderRespDTO completeOrder(CompleteOrderReqDTO reqDTO) throws MallException {
        OrderDO orderDO = orderMapper.selectById(reqDTO.getId());
        if (orderDO == null) {
            throw MallException.builder()
                    .message("该订单不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (orderDO.getIsCompleted() != 0) {
            throw MallException.builder()
                    .message("该订单已完成或取消")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (orderDO.getIsPaid() == 0) {
            throw MallException.builder()
                    .message("该订单未支付")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        orderDO.setIsCompleted(1);
        orderMapper.updateById(orderDO);
        return null;
    }
}
