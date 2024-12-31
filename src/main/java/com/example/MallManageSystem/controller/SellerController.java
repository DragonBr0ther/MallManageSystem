package com.example.MallManageSystem.controller;

import com.example.MallManageSystem.dto.req.seller.*;
import com.example.MallManageSystem.dto.resp.seller.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.exception.Response;
import com.example.MallManageSystem.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/seller")
@RestController
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping("/register")
    public Response<RegisterSellerRespDTO> registerSeller(@RequestBody RegisterSellerReqDTO requestParam) {
        try {
            RegisterSellerRespDTO respDTO = sellerService.registerSeller(requestParam);
            return Response.<RegisterSellerRespDTO>builder()
                    .data(respDTO)
                    .message("注册成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<RegisterSellerRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @DeleteMapping("/remove")
    public Response<RemoveSellerByIdRespDTO> removeSellerById(@RequestBody RemoveSellerByIdReqDTO requestParam) {
        try {
            RemoveSellerByIdRespDTO respDTO = sellerService.removeSellerById(requestParam);
            return Response.<RemoveSellerByIdRespDTO>builder()
                    .data(respDTO)
                    .message("删除成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<RemoveSellerByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/update")
    public Response<UpdateSellerInfoRespDTO> updateSellerInfo(@RequestBody UpdateSellerInfoReqDTO requestParam) {
        try {
            UpdateSellerInfoRespDTO respDTO = sellerService.updateSellerInfo(requestParam);
            return Response.<UpdateSellerInfoRespDTO>builder()
                    .data(respDTO)
                    .message("修改成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<UpdateSellerInfoRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @GetMapping("/query")
    public Response<QuerySellerByIdRespDTO> querySellerById(@RequestBody QuerySellerByIdReqDTO requestParam) {
        try {
            QuerySellerByIdRespDTO respDTO = sellerService.querySellerById(requestParam);
            return Response.<QuerySellerByIdRespDTO>builder()
                    .data(respDTO)
                    .message("查询成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<QuerySellerByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/login")
    public Response<LoginSellerRespDTO> loginSeller(@RequestBody LoginSellerReqDTO requestParam) {
        try {
            LoginSellerRespDTO respDTO = sellerService.loginSeller(requestParam);
            return Response.<LoginSellerRespDTO>builder()
                    .data(respDTO)
                    .message("登录成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<LoginSellerRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }
}
