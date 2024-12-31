package com.example.MallManageSystem.controller;

import com.example.MallManageSystem.dto.req.stat.*;
import com.example.MallManageSystem.dto.resp.seller.RegisterSellerRespDTO;
import com.example.MallManageSystem.dto.resp.stat.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.exception.Response;
import com.example.MallManageSystem.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/stat")
@RestController
@RequiredArgsConstructor
public class StatController {
    private final StatService statService;

    @GetMapping("/user")
    public Response<ConsumptionOfUserStatRespDTO> consumptionOfUserStat(@RequestBody ConsumptionOfUserStatReqDTO requestParam) {
        try {
            ConsumptionOfUserStatRespDTO respDTO = statService.consumptionOfUserStat(requestParam);
            return Response.<ConsumptionOfUserStatRespDTO>builder()
                    .data(respDTO)
                    .message("统计成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<ConsumptionOfUserStatRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @GetMapping("/product")
    public Response<SaleOfProductStatRespDTO> saleOfProductStat(@RequestBody SaleOfProductStatReqDTO requestParam) {
        try {
            SaleOfProductStatRespDTO respDTO = statService.saleOfProductStat(requestParam);
            return Response.<SaleOfProductStatRespDTO>builder()
                    .data(respDTO)
                    .message("统计成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<SaleOfProductStatRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }
}
