package com.velocity.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.velocity.inventory.model.MasterProduct;
import com.velocity.inventory.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	@Transactional
	public void testProductRevisions() {
		// Create and save a new product
		MasterProduct product = new MasterProduct();
		product.setProductName("Test Product");
		product.setDescription("Test Description");
		product.setProductPrice(BigDecimal.valueOf(100.0));
		product.setQuantity(10);
		productService.save(product);

		// Update the product
		product.setProductPrice(BigDecimal.valueOf(120.0));
		productService.save1(product);

		// Fetch the revisions
		List<MasterProduct> revisions = productService.getRevisions(product.getId());
		// Assert and verify revisions
	}
}
