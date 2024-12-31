package com.example.MallManageSystem.controller;

import com.example.MallManageSystem.dto.req.order.*;
import com.example.MallManageSystem.dto.resp.order.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.exception.Response;
import com.example.MallManageSystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/place")
    public Response<PlaceOrderRespDTO> placeOrder(@RequestBody PlaceOrderReqDTO requestParam) {
        try {
            PlaceOrderRespDTO respDTO = orderService.placeOrder(requestParam);
            return Response.<PlaceOrderRespDTO>builder()
                    .data(respDTO)
                    .message("下单成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<PlaceOrderRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/pay")
    public Response<PayOrderRespDTO> payOrder(@RequestBody PayOrderReqDTO requestParam){
        try {
            PayOrderRespDTO respDTO = orderService.payOrder(requestParam);
            return Response.<PayOrderRespDTO>builder()
                    .data(respDTO)
                    .message("支付成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<PayOrderRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/cancel")
    public Response<CancelOrderRespDTO> cancelOrder(@RequestBody CancelOrderReqDTO requestParam){
        try {
            CancelOrderRespDTO respDTO = orderService.cancelOrder(requestParam);
            return Response.<CancelOrderRespDTO>builder()
                    .data(respDTO)
                    .message("取消成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<CancelOrderRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/complete")
    public Response<CompleteOrderRespDTO> completeOrder(@RequestBody CompleteOrderReqDTO requestParam){
        try {
            CompleteOrderRespDTO respDTO = orderService.completeOrder(requestParam);
            return Response.<CompleteOrderRespDTO>builder()
                    .data(respDTO)
                    .message("订单完成")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<CompleteOrderRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

}
