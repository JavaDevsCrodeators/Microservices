package com.velocity.inventory.service;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Service;

import com.velocity.inventory.model.MasterProduct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AuditService {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Object[]> getRevisions(Long productId) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		return auditReader.createQuery().forRevisionsOfEntity(MasterProduct.class, false, true)
				.add(AuditEntity.id().eq(productId)).getResultList();
	}
}
