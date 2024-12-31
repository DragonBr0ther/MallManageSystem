package com.example.MallManageSystem.service;

import com.example.MallManageSystem.dto.req.seller.*;
import com.example.MallManageSystem.dto.resp.seller.*;
import com.example.MallManageSystem.exception.MallException;

/**
 * 卖家服务接口,定义了与卖家相关的业务逻辑操作。
 * 提供卖家的注册、删除、更新信息、查询以及登录等操作。
 */
public interface SellerService {
    /**
     * 注册一个新的卖家。
     *
     * @param reqDTO 包含卖家注册所需的详细信息的请求对象。
     * @return 返回注册成功的响应对象 {@link RegisterSellerRespDTO}，其中包含注册后的相关信息。
     * @throws MallException 如果在注册过程中发生错误（如卖家信息不合法），将抛出该异常。
     */
    RegisterSellerRespDTO registerSeller(RegisterSellerReqDTO reqDTO) throws MallException;

    /**
     * 根据卖家 ID 移除一个卖家。
     *
     * @param reqDTO 包含要删除的卖家 ID 的请求对象。
     * @return 返回移除操作的响应对象 {@link RemoveSellerByIdRespDTO}，其中包含移除操作的结果。
     * @throws MallException 如果在删除过程中发生错误（如卖家 ID 无效），将抛出该异常。
     */
    RemoveSellerByIdRespDTO removeSellerById (RemoveSellerByIdReqDTO reqDTO) throws MallException;

    /**
     * 更新卖家的信息。
     *
     * @param reqDTO 包含要更新的卖家信息的请求对象 {@link UpdateSellerInfoReqDTO}。
     * @return 返回更新操作的响应对象 {@link UpdateSellerInfoRespDTO}，其中包含更新后的卖家信息。
     * @throws MallException 如果在更新过程中发生错误（如卖家信息不合法），将抛出该异常。
     */
    UpdateSellerInfoRespDTO updateSellerInfo(UpdateSellerInfoReqDTO reqDTO) throws MallException;

    /**
     * 根据卖家 ID 查询卖家的详细信息。
     *
     * @param reqDTO 包含卖家 ID 的查询请求对象 {@link QuerySellerByIdReqDTO}。
     * @return 返回查询结果的响应对象 {@link QuerySellerByIdRespDTO}，其中包含卖家的详细信息。
     * @throws MallException 如果在查询过程中发生错误（如卖家 ID 无效），将抛出该异常。
     */
    QuerySellerByIdRespDTO querySellerById(QuerySellerByIdReqDTO reqDTO) throws MallException;

    /**
     * 卖家登录验证。
     *
     * @param reqDTO 包含卖家登录所需的凭证（如用户名、密码等）的请求对象 {@link LoginSellerReqDTO}。
     * @return 返回登录成功后的响应对象 {@link LoginSellerRespDTO}。
     * @throws MallException 如果在登录过程中发生错误（如凭证错误、卖家状态问题等），将抛出该异常。
     */
    LoginSellerRespDTO loginSeller(LoginSellerReqDTO reqDTO) throws MallException;
}
