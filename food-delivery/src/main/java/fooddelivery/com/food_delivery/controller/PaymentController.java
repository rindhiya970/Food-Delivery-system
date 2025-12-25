package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/api/payment/test")
    public String testPayment() {
        return paymentService.processPayment();
    }
}
