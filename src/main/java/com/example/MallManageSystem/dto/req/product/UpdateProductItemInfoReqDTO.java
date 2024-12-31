package com.example.MallManageSystem.dto.req.product;

import lombok.Data;

@Data
public class UpdateProductItemInfoReqDTO {
    private Integer id;

    private Integer stockQuantity;

    private Double price;

    private String description;
}
