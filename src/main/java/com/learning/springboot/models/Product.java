package com.learning.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PRODUCT_INFO")
@Data
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	private String productId;

	@Column(name = "PRODUCT_NAME")
	private String pname;

	@Column(name = "PRODUCT_PRICE")
	private float price;

	@Column(name = "PRODUCT_QUANTITY")
	private int quantity;

	@Column(name = "PRODUCT_SKU")
	private String sku;

	@Column(name = "PRODUCT_DISCOUNT")
	private int discount;

}
