package com.example.MallManageSystem.service;

import com.example.MallManageSystem.dto.req.product.*;
import com.example.MallManageSystem.dto.resp.product.*;
import com.example.MallManageSystem.exception.MallException;

/**
 * ProductService 接口定义了关于产品的各类服务操作，包括产品的添加、删除、更新和查询等。
 * 每个方法都可能会抛出 MallException 异常，表明在进行操作时可能会出现业务逻辑上的错误或系统异常。
 */
public interface ProductService {

    /**
     * 添加新产品
     *
     * @param reqDTO 包含新增产品信息的请求对象
     * @return 返回添加操作的响应结果，包括添加成功与否的状态信息
     * @throws MallException 如果添加过程中出现任何异常，如产品信息不符合要求
     */
    AddProductRespDTO addProduct(AddProductReqDTO reqDTO) throws MallException;

    /**
     * 根据产品 ID 删除产品
     *
     * @param reqDTO 包含要删除的产品 ID 的请求对象
     * @return 返回删除操作的响应结果，包含操作成功与否的状态信息
     * @throws MallException 如果删除过程中出现任何异常，如产品不存在
     */
    RemoveProductByIdRespDTO removeProductById(RemoveProductByIdReqDTO reqDTO) throws MallException;

    /**
     * 更新产品信息
     *
     * @param reqDTO 包含更新后产品信息的请求对象
     * @return 返回更新操作的响应结果，包括更新成功与否的状态信息
     * @throws MallException 如果更新过程中出现任何异常，如产品信息不合法
     */
    UpdateProductInfoRespDTO updateProductInfo(UpdateProductInfoReqDTO reqDTO) throws MallException;

    /**
     * 根据产品 ID 查询产品信息
     *
     * @param reqDTO 包含查询产品 ID 的请求对象
     * @return 返回查询结果，包含产品的详细信息
     * @throws MallException 如果查询过程中出现任何异常，如产品不存在
     */
    QueryProductByIdRespDTO queryProductInfoById(QueryProductByIdReqDTO reqDTO) throws MallException;

    /**
     * 添加产品项
     *
     * @param reqDTO 包含新增产品项信息的请求对象
     * @return 返回添加操作的响应结果，包含添加成功与否的状态信息
     * @throws MallException 如果添加过程中出现任何异常，如产品项信息不合法
     */
    AddProductItemRespDTO addProductItem(AddProductItemReqDTO reqDTO) throws MallException;

    /**
     * 根据产品项 ID 删除产品项
     *
     * @param reqDTO 包含要删除的产品项 ID 的请求对象
     * @return 返回删除操作的响应结果，包含删除成功与否的状态信息
     * @throws MallException 如果删除过程中出现任何异常，如产品项不存在
     */
    RemoveProductItemByIdRespDTO removeProductItemById(RemoveProductItemByIdReqDTO reqDTO) throws MallException;

    /**
     * 更新产品项信息
     *
     * @param reqDTO 包含更新后产品项信息的请求对象
     * @return 返回更新操作的响应结果，包括更新成功与否的状态信息
     * @throws MallException 如果更新过程中出现任何异常，如产品项信息不合法
     */
    UpdateProductItemInfoRespDTO updateProductItemInfo(UpdateProductItemInfoReqDTO reqDTO) throws MallException;

    /**
     * 根据产品项 ID 查询产品项信息
     *
     * @param reqDTO 包含查询产品项 ID 的请求对象
     * @return 返回查询结果，包含产品项的详细信息
     * @throws MallException 如果查询过程中出现任何异常，如产品项不存在
     */
    QueryProductItemByIdRespDTO queryProductItemInfoById(QueryProductItemByIdReqDTO reqDTO) throws MallException;
}

