package com.example.MallManageSystem.dto.resp.seller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuerySellerByIdRespDTO {
    private String account;

    private String name;

    private String phone;

    private String email;

    private String introduction;
}
