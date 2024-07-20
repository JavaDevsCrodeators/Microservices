package com.velocity.order.service;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;

import com.velocity.order.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AuditService {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Number> getOrderRevisions(Long orderId) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		return auditReader.getRevisions(Order.class, orderId);
	}

	public Order getOrderAtRevision(Long orderId, Number revision) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		return auditReader.find(Order.class, orderId, revision);
	}
}
