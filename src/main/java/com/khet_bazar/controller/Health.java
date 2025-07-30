package com.khet_bazar.controller;

import com.khet_bazar.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Health {
    public BaseResponse createResponse() {
        return BaseResponse.builder()
                .status("OK")
                .build();
    }

    @GetMapping("/health")
    public BaseResponse health() {
        return createResponse();
    }
}
