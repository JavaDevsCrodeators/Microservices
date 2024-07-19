package com.velocity.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.velocity.payment.model.PaymentRequest;
import com.velocity.payment.repo.PaymentRequestRepository;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentRequestService {

	@Autowired
	private PaymentRequestRepository paymentRequestRepository;

	@Transactional
	public PaymentRequest savePaymentRequest(PaymentRequest paymentRequest) {
		return paymentRequestRepository.save(paymentRequest);
	}

	public List<PaymentRequest> getAllPaymentRequests() {
		return paymentRequestRepository.findAll();
	}

	@Transactional
	public void updatePaymentRequest(Long requestId, BigDecimal newTotalAmount) {
		PaymentRequest paymentRequest = paymentRequestRepository.findById(requestId)
				.orElseThrow(() -> new RuntimeException("Payment request not found"));
		paymentRequest.setTotalAmount(newTotalAmount);
		paymentRequestRepository.save(paymentRequest);
	}

	@Transactional
	public void deletePaymentRequest(Long requestId) {
		paymentRequestRepository.deleteById(requestId);
	}
}
