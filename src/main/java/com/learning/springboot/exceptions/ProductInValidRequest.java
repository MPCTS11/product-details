package com.learning.springboot.exceptions;

public class ProductInValidRequest extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductInValidRequest() {
		super();
	}

	public ProductInValidRequest(String s) {
		super(s);
	}

}
