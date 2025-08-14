package com.vnrgh.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService service;

    public FraudController(FraudCheckService service) {
        this.service = service;
    }

    @GetMapping(path = "{customerId}")
    private FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = service.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
