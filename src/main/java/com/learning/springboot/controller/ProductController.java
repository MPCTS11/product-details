package com.learning.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.exceptions.ProductInValidRequest;
import com.learning.springboot.models.Product;
import com.learning.springboot.services.ProductService;

import javassist.tools.web.BadHttpRequest;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/create-product")
	public ResponseEntity<String> addProduct(@RequestBody Product product) throws ProductInValidRequest {
		Product productResponse = productService.addProduct(product);
		if (productResponse != null) {
			return new ResponseEntity<String>("Product Created Successfully" , HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Product is fialed to create", HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/get-products")
	public List<Product> getAllProducts(Product product) {
		return productService.getAllProducts(product);
	}

	@DeleteMapping("/delete-products")
	public void deleteAllProducts(Product product) {
		productService.deleteAllProducts(product);
	}

	@PutMapping("/edit-product/{productId}")
	public Product editProductById(@RequestBody Product product, @PathVariable String productId) throws BadHttpRequest {
		return productService.editProduct(product, productId);
	}

	@GetMapping("/get-product/{productId}")
	public Optional<Product> getProductById(@PathVariable String productId) {
		return productService.getProductById(productId);
	}

	@DeleteMapping("/delete-product/{productId}")
	public void deleteProductById(@PathVariable String productId) {
		productService.deleteProductById(productId);
	}
}