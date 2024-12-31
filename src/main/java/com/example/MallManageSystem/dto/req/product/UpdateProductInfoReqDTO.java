package com.example.MallManageSystem.dto.req.product;

import lombok.Data;

@Data
public class UpdateProductInfoReqDTO {
    private Integer id;

    private String name;

    private String introduction;
}
