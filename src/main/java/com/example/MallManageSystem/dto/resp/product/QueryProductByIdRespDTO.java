package com.example.MallManageSystem.dto.resp.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryProductByIdRespDTO {
    private Integer sellerId;

    private Integer categoryId;

    private String name;

    private String introduction;
}
