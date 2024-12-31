package com.example.MallManageSystem.dto.resp.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryProductItemByIdRespDTO {
    private Integer productId;

    private Integer stockQuantity;

    private Double price;

    private String description;
}
