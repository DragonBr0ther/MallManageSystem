package com.example.MallManageSystem.dto.req.order;

import lombok.Data;

@Data
public class PlaceOrderReqDTO {
    private Integer userId;

    private Integer userAddressId;

    private Integer productId;

    private Integer productItemId;

    private Integer quantity;
}
