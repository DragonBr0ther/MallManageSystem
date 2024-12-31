package com.example.MallManageSystem.dto.resp.stat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaleOfProductStatRespDTO {
    private Integer orderCount;
    private Double totalAmount;
}
