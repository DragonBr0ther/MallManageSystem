package com.example.MallManageSystem.service;

import com.example.MallManageSystem.dto.req.user.*;
import com.example.MallManageSystem.dto.resp.user.*;
import com.example.MallManageSystem.exception.MallException;

/**
 * 用户服务接口，定义了与用户相关的基本操作。
 * 提供用户注册、删除、更新信息、查询及登录功能。
 */
public interface UserService {
    /**
     * 注册用户。
     *
     * @param reqDTO 包含用户注册信息的请求数据传输对象。
     * @return 注册结果的响应数据传输对象，包含注册成功后的用户信息。
     * @throws MallException 如果注册过程中发生任何异常（例如，账号已存在等），抛出此异常。
     */
    RegisterUserRespDTO registerUser (RegisterUserReqDTO reqDTO) throws MallException;

    /**
     * 根据用户ID删除用户。
     *
     * @param reqDTO 包含待删除用户ID的请求数据传输对象。
     * @return 删除操作的响应数据传输对象，包含操作结果信息。
     * @throws MallException 如果删除过程中发生任何异常（例如，用户ID无效等），抛出此异常。
     */
    RemoveUserByIdRespDTO removeUserById (RemoveUserByIdReqDTO reqDTO) throws MallException;

    /**
     * 更新用户信息。
     *
     * @param reqDTO 包含待更新的用户信息的请求数据传输对象。
     * @return 更新操作的响应数据传输对象，包含更新后的用户信息。
     * @throws MallException 如果更新过程中发生任何异常（例如，用户信息无效等），抛出此异常。
     */
    UpdateUserInfoRespDTO updateUserInfo(UpdateUserInfoReqDTO reqDTO) throws MallException;

    /**
     * 根据用户ID查询用户信息。
     *
     * @param reqDTO 包含用户ID的请求数据传输对象。
     * @return 查询结果的响应数据传输对象，包含查询到的用户信息。
     * @throws MallException 如果查询过程中发生任何异常（例如，用户ID不存在等），抛出此异常。
     */
    QueryUserByIdRespDTO queryUserById (QueryUserByIdReqDTO reqDTO) throws MallException;

    /**
     * 用户登录。
     *
     * @param reqDTO 包含用户登录凭证的请求数据传输对象。
     * @return 登录结果的响应数据传输对象，包含用户登录后的信息。
     * @throws MallException 如果登录过程中发生任何异常（例如，账号或密码错误等），抛出此异常。
     */
    LoginUserRespDTO loginUser(LoginUserReqDTO reqDTO) throws MallException;
}
