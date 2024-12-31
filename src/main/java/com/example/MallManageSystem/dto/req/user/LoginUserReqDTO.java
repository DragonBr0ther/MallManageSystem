package com.example.MallManageSystem.dto.req.user;

import lombok.Data;

@Data
public class LoginUserReqDTO {
    private String account;

    private String password;
}
