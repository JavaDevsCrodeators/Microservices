package com.velocity.payment.repo;

	import org.springframework.data.jpa.repository.JpaRepository;
	import com.velocity.payment.model.PaymentRequest;

	public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, Long> {
	}
