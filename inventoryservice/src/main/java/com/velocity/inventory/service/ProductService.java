package com.velocity.inventory.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velocity.inventory.model.MasterProduct;

@Service
public class ProductService {
	@Autowired
	private EntityManager entityManager;

	public List<MasterProduct> getRevisions(Long productId) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		return auditReader.createQuery().forRevisionsOfEntity(MasterProduct.class, false, true)
				.add(AuditEntity.id().eq(productId)).getResultList();
	}

	public void save(MasterProduct product) {
		// TODO Auto-generated method stub

	}

	public void save1(MasterProduct product) {
		// TODO Auto-generated method stub

	}
}
