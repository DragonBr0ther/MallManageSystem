package com.example.MallManageSystem.controller;

import com.example.MallManageSystem.dto.req.product.*;
import com.example.MallManageSystem.dto.resp.product.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.exception.Response;
import com.example.MallManageSystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public Response<AddProductRespDTO> addProduct(@RequestBody AddProductReqDTO requestParam) {
        try {
            AddProductRespDTO respDTO = productService.addProduct(requestParam);
            return Response.<AddProductRespDTO>builder()
                    .data(respDTO)
                    .message("添加成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<AddProductRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @DeleteMapping("/remove")
    public Response<RemoveProductByIdRespDTO> removeProductById(@RequestBody RemoveProductByIdReqDTO requestParam) {
        try {
            RemoveProductByIdRespDTO respDTO = productService.removeProductById(requestParam);
            return Response.<RemoveProductByIdRespDTO>builder()
                    .data(respDTO)
                    .message("删除成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<RemoveProductByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/update")
    public Response<UpdateProductInfoRespDTO> updateProductInfo(@RequestBody UpdateProductInfoReqDTO requestParam) {
        try {
            UpdateProductInfoRespDTO respDTO = productService.updateProductInfo(requestParam);
            return Response.<UpdateProductInfoRespDTO>builder()
                    .data(respDTO)
                    .message("修改成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<UpdateProductInfoRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @GetMapping("/query")
    public Response<QueryProductByIdRespDTO> queryProductById(@RequestBody QueryProductByIdReqDTO requestParam) {
        try {
            QueryProductByIdRespDTO respDTO = productService.queryProductInfoById(requestParam);
            return Response.<QueryProductByIdRespDTO>builder()
                    .data(respDTO)
                    .message("查询成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<QueryProductByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/item/add")
    public Response<AddProductItemRespDTO> addProductItem(@RequestBody AddProductItemReqDTO requestParam) {
        try {
            AddProductItemRespDTO respDTO = productService.addProductItem(requestParam);
            return Response.<AddProductItemRespDTO>builder()
                    .data(respDTO)
                    .message("添加成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<AddProductItemRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @DeleteMapping("/item/remove")
    public Response<RemoveProductItemByIdRespDTO> removeProductItemById(@RequestBody RemoveProductItemByIdReqDTO requestParam) {
        try {
            RemoveProductItemByIdRespDTO respDTO = productService.removeProductItemById(requestParam);
            return Response.<RemoveProductItemByIdRespDTO>builder()
                    .data(respDTO)
                    .message("删除成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<RemoveProductItemByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @PostMapping("/item/update")
    public Response<UpdateProductItemInfoRespDTO> updateProductItemInfo(@RequestBody UpdateProductItemInfoReqDTO requestParam) {
        try {
            UpdateProductItemInfoRespDTO respDTO = productService.updateProductItemInfo(requestParam);
            return Response.<UpdateProductItemInfoRespDTO>builder()
                    .data(respDTO)
                    .message("修改成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<UpdateProductItemInfoRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }

    @GetMapping("/item/query")
    public Response<QueryProductItemByIdRespDTO> queryProductItemById(@RequestBody QueryProductItemByIdReqDTO requestParam) {
        try {
            QueryProductItemByIdRespDTO respDTO = productService.queryProductItemInfoById(requestParam);
            return Response.<QueryProductItemByIdRespDTO>builder()
                    .data(respDTO)
                    .message("查询成功")
                    .statusCode(HttpStatus.OK)
                    .build();
        } catch (MallException e) {
            return Response.<QueryProductItemByIdRespDTO>builder()
                    .message(e.getMessage())
                    .statusCode(e.getStatusCode())
                    .build();
        }
    }
}
