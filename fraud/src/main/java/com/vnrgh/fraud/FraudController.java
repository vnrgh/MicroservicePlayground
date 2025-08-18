package com.vnrgh.fraud;

import com.vnrgh.clients.fraud.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {

    private final FraudCheckService service;

    public FraudController(FraudCheckService service) {
        this.service = service;
    }

    @GetMapping(path = "{customerId}")
    private FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = service.isFraudulentCustomer(customerId);
        log.info("FRAUD CHECK REQUEST FOR CUSTOMER {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
