package com.example.MallManageSystem.dto.resp.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceOrderRespDTO {
    private Double payAmount;
}
