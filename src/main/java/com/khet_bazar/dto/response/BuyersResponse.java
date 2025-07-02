package com.khet_bazar.dto.response;

import com.khet_bazar.entity.Buyer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class BuyersResponse extends BaseResponse {
    private List<Buyer> data;
}
