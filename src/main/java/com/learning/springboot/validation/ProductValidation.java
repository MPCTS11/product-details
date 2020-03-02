package com.learning.springboot.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.learning.springboot.models.Product;

@Component
public class ProductValidation {

	public boolean validateProductRequest(Product product) {
		if (!StringUtils.isEmpty(product.getProductId()) && !StringUtils.isEmpty(product.getPname())
				&& product.getPrice() != 0) {
			return true;
		}
		return false;
	}

}
