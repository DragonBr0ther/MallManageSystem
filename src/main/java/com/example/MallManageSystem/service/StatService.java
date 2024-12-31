package com.example.MallManageSystem.service;

import com.example.MallManageSystem.dto.req.stat.*;
import com.example.MallManageSystem.dto.resp.stat.*;
import com.example.MallManageSystem.exception.MallException;

/**
 * 统计服务接口，定义了与统计相关的业务方法。
 * 该接口提供了获取用户消费统计信息和商品销售统计信息的功能。
 */
public interface StatService {

    /**
     * 获取用户消费统计信息。
     *
     * @param reqDTO 请求参数，包含查询用户消费统计所需的信息。
     * @return 返回用户消费统计的响应数据，包括消费金额、消费次数等信息。
     * @throws MallException 如果在处理请求过程中发生任何异常（如数据库错误等），抛出此异常。
     */
    ConsumptionOfUserStatRespDTO consumptionOfUserStat(ConsumptionOfUserStatReqDTO reqDTO) throws MallException;

    /**
     * 获取商品销售统计信息。
     *
     * @param reqDTO 请求参数，包含查询商品销售统计所需的信息。
     * @return 返回商品销售统计的响应数据，包括销售数量、销售金额等信息。
     * @throws MallException 如果在处理请求过程中发生任何异常（如数据库错误等），抛出此异常。
     */
    SaleOfProductStatRespDTO saleOfProductStat(SaleOfProductStatReqDTO reqDTO) throws MallException;
}
