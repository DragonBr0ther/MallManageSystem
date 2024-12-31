package com.example.MallManageSystem.service;

import com.example.MallManageSystem.dto.req.order.*;
import com.example.MallManageSystem.dto.resp.order.*;
import com.example.MallManageSystem.exception.MallException;

/**
 * OrderService 接口提供了关于订单处理的各类操作，包括创建订单、支付订单、取消订单和完成订单。
 * 每个方法都可能会抛出 {@link MallException}，表示在执行过程中发生了业务异常。
 */
public interface OrderService {

    /**
     * 创建订单。
     *
     * @param reqDTO 包含创建订单所需的信息的请求对象，通常包括商品信息、用户信息等。
     * @return 返回订单创建的响应对象，包含订单的基本信息，如订单号、状态等。
     * @throws MallException 如果订单创建过程中发生错误，抛出此异常。
     */
    PlaceOrderRespDTO placeOrder(PlaceOrderReqDTO reqDTO) throws MallException;

    /**
     * 支付订单。
     *
     * @param reqDTO 包含支付订单所需的信息的请求对象。
     * @return 返回支付成功后的响应对象。
     * @throws MallException 如果支付过程中发生错误，抛出此异常。
     */
    PayOrderRespDTO payOrder(PayOrderReqDTO reqDTO) throws MallException;

    /**
     * 取消订单。
     *
     * @param reqDTO 包含取消订单所需的信息的请求对象。
     * @return 返回取消订单后的响应对象。
     * @throws MallException 如果订单取消过程中发生错误，抛出此异常。
     */
    CancelOrderRespDTO cancelOrder(CancelOrderReqDTO reqDTO) throws MallException;

    /**
     * 完成订单。
     *
     * @param reqDTO 包含完成订单所需的信息的请求对象。
     * @return 返回订单完成后的响应对象。
     * @throws MallException 如果订单完成过程中发生错误，抛出此异常。
     */
    CompleteOrderRespDTO completeOrder(CompleteOrderReqDTO reqDTO) throws MallException;
}

