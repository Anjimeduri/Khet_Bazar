package com.khet_bazar.controller;

import com.khet_bazar.dto.response.BuyersResponse;
import com.khet_bazar.entity.Buyer;
import com.khet_bazar.service.BuyersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buyers")
public class BuyerController extends BaseController<BuyersResponse, Buyer> {
    public BuyerController(BuyersService buyersService) {
        super(buyersService);
    }

    public BuyersResponse createResponse(List<Buyer> buyerList) {
        return BuyersResponse.builder()
                .data(buyerList)
                .status("OK")
                .build();
    }
}
