package com.example.MallManageSystem.controller;

import com.example.MallManageSystem.service.UserService;
import com.example.MallManageSystem.dto.req.user.*;
import com.example.MallManageSystem.dto.resp.user.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.exception.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public Response<RegisterUserRespDTO> registerUser(@RequestBody RegisterUserReqDTO requestParam) {
        try {
            RegisterUserRespDTO respDTO = userService.registerUser(requestParam);
            return Response.<RegisterUserRespDTO>builder()
                    .data(respDTO)
                    .message("注册成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        }catch (MallException e) {
            return Response.<RegisterUserRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @DeleteMapping("/remove")
    public Response<RemoveUserByIdRespDTO> removeUserById(@RequestBody RemoveUserByIdReqDTO requestParam) {
        try {
            RemoveUserByIdRespDTO respDTO = userService.removeUserById(requestParam);
            return Response.<RemoveUserByIdRespDTO>builder()
                    .data(respDTO)
                    .message("删除成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        }catch (MallException e) {
            return Response.<RemoveUserByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/update")
    public Response<UpdateUserInfoRespDTO> updateUserInfo(@RequestBody UpdateUserInfoReqDTO requestParam) {
        try {
            UpdateUserInfoRespDTO respDTO = userService.updateUserInfo(requestParam);
            return Response.<UpdateUserInfoRespDTO>builder()
                    .data(respDTO)
                    .message("修改成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        }catch (MallException e) {
            return Response.<UpdateUserInfoRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @GetMapping("/query")
    public Response<QueryUserByIdRespDTO> queryUserById(@RequestBody QueryUserByIdReqDTO requestParam) {
        try {
            QueryUserByIdRespDTO respDTO = userService.queryUserById(requestParam);
            return Response.<QueryUserByIdRespDTO>builder()
                    .data(respDTO)
                    .message("查询成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        }catch (MallException e) {
            return Response.<QueryUserByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/login")
    public Response<LoginUserRespDTO> loginUser(@RequestBody LoginUserReqDTO requestParam) {
        try {
            LoginUserRespDTO respDTO = userService.loginUser(requestParam);
            return Response.<LoginUserRespDTO>builder()
                    .data(respDTO)
                    .message("登录成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        }catch (MallException e) {
            return Response.<LoginUserRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }
}
