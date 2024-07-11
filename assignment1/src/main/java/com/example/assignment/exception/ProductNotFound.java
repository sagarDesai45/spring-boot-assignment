package com.example.assignment.exception;

public class ProductNotFound extends RuntimeException {
    
	public ProductNotFound(String message) {
        super(message);
    }
}
