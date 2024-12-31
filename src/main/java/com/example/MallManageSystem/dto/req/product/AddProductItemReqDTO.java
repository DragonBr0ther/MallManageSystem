package com.example.MallManageSystem.dto.req.product;

import lombok.Data;

@Data
public class AddProductItemReqDTO {
    private Integer productId;

    private Integer stockQuantity;

    private Double price;

    private String description;
}
