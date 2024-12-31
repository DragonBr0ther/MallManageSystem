package com.example.MallManageSystem.service.impl;

import com.example.MallManageSystem.dao.entity.ProductDO;
import com.example.MallManageSystem.dao.entity.ProductItemDO;
import com.example.MallManageSystem.dao.mapper.ProductItemMapper;
import com.example.MallManageSystem.dao.mapper.ProductMapper;
import com.example.MallManageSystem.dao.mapper.SellerMapper;
import com.example.MallManageSystem.dto.req.product.*;
import com.example.MallManageSystem.dto.resp.product.*;
import com.example.MallManageSystem.exception.MallException;
import com.example.MallManageSystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductItemMapper productItemMapper;
    private final SellerMapper sellerMapper;

    @Override
    public AddProductRespDTO addProduct(AddProductReqDTO reqDTO) throws MallException {
        if (sellerMapper.selectById(reqDTO.getSellerId()) == null) {
            throw MallException.builder()
                    .message("该商家不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        ProductDO productDO = ProductDO.builder()
                .sellerId(reqDTO.getSellerId())
                .categoryId(1)
                .name(reqDTO.getName())
                .introduction(reqDTO.getIntroduction())
                .build();
        productMapper.insert(productDO);
        return null;
    }

    @Override
    public RemoveProductByIdRespDTO removeProductById(RemoveProductByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (productMapper.selectById(id) != null) {
            productMapper.deleteById(id);
        } else {
            throw MallException.builder()
                    .message("该商品不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public UpdateProductInfoRespDTO updateProductInfo(UpdateProductInfoReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (productMapper.selectById(id) != null) {
            ProductDO productDO = ProductDO.builder()
                    .id(reqDTO.getId())
                    .name(reqDTO.getName())
                    .introduction(reqDTO.getIntroduction())
                    .build();
            productMapper.updateById(productDO);
        } else {
            throw MallException.builder()
                    .message("该产品不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public QueryProductByIdRespDTO queryProductInfoById(QueryProductByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        ProductDO productDO = productMapper.selectById(id);
        if (productDO != null) {
            return QueryProductByIdRespDTO.builder()
                    .sellerId(productDO.getSellerId())
                    .categoryId(productDO.getCategoryId())
                    .name(productDO.getName())
                    .introduction(productDO.getIntroduction())
                    .build();
        } else {
            throw MallException.builder()
                    .message("该商品不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @Override
    public AddProductItemRespDTO addProductItem(AddProductItemReqDTO reqDTO) throws MallException {
        if (productMapper.selectById(reqDTO.getProductId()) == null) {
            throw MallException.builder()
                    .message("该商品不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        ProductItemDO productItemDO = ProductItemDO.builder()
                .productId(reqDTO.getProductId())
                .stockQuantity(reqDTO.getStockQuantity())
                .price(reqDTO.getPrice())
                .description(reqDTO.getDescription())
                .build();
        productItemMapper.insert(productItemDO);
        return null;
    }

    @Override
    public RemoveProductItemByIdRespDTO removeProductItemById(RemoveProductItemByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (productItemMapper.selectById(id) != null) {
            productItemMapper.deleteById(id);
        } else {
            throw MallException.builder()
                    .message("该商品分类不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public UpdateProductItemInfoRespDTO updateProductItemInfo(UpdateProductItemInfoReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        if (productItemMapper.selectById(id) != null) {
            ProductItemDO productItemDO = ProductItemDO.builder()
                    .id(reqDTO.getId())
                    .stockQuantity(reqDTO.getStockQuantity())
                    .price(reqDTO.getPrice())
                    .description(reqDTO.getDescription())
                    .build();
            productItemMapper.updateById(productItemDO);
        } else {
            throw MallException.builder()
                    .message("该产品分类不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
        return null;
    }

    @Override
    public QueryProductItemByIdRespDTO queryProductItemInfoById(QueryProductItemByIdReqDTO reqDTO) throws MallException {
        Integer id = reqDTO.getId();
        ProductItemDO productItemDO = productItemMapper.selectById(id);
        if (productItemDO != null) {
            return QueryProductItemByIdRespDTO.builder()
                    .productId(productItemDO.getProductId())
                    .stockQuantity(productItemDO.getStockQuantity())
                    .price(productItemDO.getPrice())
                    .description(productItemDO.getDescription())
                    .build();
        } else {
            throw MallException.builder()
                    .message("该商品分类不存在")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}
