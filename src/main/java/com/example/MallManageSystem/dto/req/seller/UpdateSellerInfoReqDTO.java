package com.example.MallManageSystem.dto.req.seller;

import lombok.Data;

@Data
public class UpdateSellerInfoReqDTO {
    private Integer id;

    private String name;

    private String phone;

    private String email;

    private String introduction;
}
