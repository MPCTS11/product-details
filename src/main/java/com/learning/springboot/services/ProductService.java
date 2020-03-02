package com.learning.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.exceptions.ProductInValidRequest;
import com.learning.springboot.models.Product;
import com.learning.springboot.repository.ProductRepository;
import com.learning.springboot.validation.ProductValidation;

import javassist.tools.web.BadHttpRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductValidation productValidation;

	public Product addProduct(Product product) throws ProductInValidRequest {
		log.info("Inserting the product in Service ..");	
		
		boolean valid = productValidation.validateProductRequest(product);
		log.info("Validation complted  ..");
		if (valid) {
			log.info("calling database to create product ..");
			return productRepository.save(product);
		} else {
			throw new ProductInValidRequest("Product Request Invalid..");
		}
	}

	public List<Product> getAllProducts(Product product) {
		return productRepository.findAll();

	}

	public void deleteAllProducts(Product product) {
		productRepository.deleteAll();

	}

	public Product editProduct(Product product, String productId) throws BadHttpRequest {
		Optional<Product> product1 = getProductById(productId);
		if(product1.isPresent())
		{
		return productRepository.save(product);
		}
		else
		{
			throw new BadHttpRequest();
		}
	}

	public Optional<Product> getProductById(String productId) {
		
		return productRepository.findById(productId);

	}

	public void deleteProductById(String ProductId) {
		productRepository.deleteById(ProductId);

	}

}
