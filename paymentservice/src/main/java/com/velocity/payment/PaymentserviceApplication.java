package com.velocity.payment;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.velocity.payment.model.PaymentMode;
import com.velocity.payment.model.PaymentRequest;
import com.velocity.payment.service.PaymentRequestService;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class PaymentserviceApplication {

	@Autowired
	private PaymentRequestService paymentRequestService;

	public static void main(String[] args) {
		SpringApplication.run(PaymentserviceApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// Create a payment request
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(1L);
		paymentRequest.setTotalAmount(new BigDecimal("100.00"));
		paymentRequest.setPaymentMode(PaymentMode.CREDIT_CARD);

		// Save payment request
		paymentRequestService.savePaymentRequest(paymentRequest);

		// Update payment request
		paymentRequestService.updatePaymentRequest(paymentRequest.getOrderId(), new BigDecimal("150.00"));

		// Delete payment request
		paymentRequestService.deletePaymentRequest(paymentRequest.getOrderId());
	}
}
