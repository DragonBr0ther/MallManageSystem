package com.example.MallManageSystem.dto.req.user;

import lombok.Data;

@Data
public class UpdateUserInfoReqDTO {
    private Integer id;

    private String name;

    private String phone;

    private String email;

    private String gender;
}
