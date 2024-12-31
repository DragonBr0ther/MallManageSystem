package com.example.MallManageSystem.dto.resp.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryUserByIdRespDTO {
    private String account;

    private String name;

    private String phone;

    private String email;

    private String gender;
}
