package com.example.MallManageSystem.dto.req.product;

import lombok.Data;

@Data
public class AddProductReqDTO {
    private Integer sellerId;

    private Integer categoryId;

    private String name;

    private String introduction;
}
