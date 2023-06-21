package com.Payment.Controller;

import com.Payment.Service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    //http://localhost:8080/payment/create-order
    @PostMapping("/create-order")
    public String createOrder(@RequestParam("amount") int amount, @RequestParam("currency") String currency) throws RazorpayException {
        String orderId = paymentService.createOrder(amount, currency);
        return "Order created with ID: " + orderId;
    }
    //http://localhost:8080/payment/verify-signature
    @PostMapping("/verify-signature")
    public String verifyPaymentSignature(@RequestParam String orderId, @RequestParam String paymentId, @RequestParam String signature) throws RazorpayException {
        return paymentService.verifyPaymentSignature(orderId, paymentId, signature);
    }  // Other controller methods for payment callbacks, etc.

}


