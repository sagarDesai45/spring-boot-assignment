package com.example.assignment.service;



import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.assignment.dao.entity.Product;
import com.example.assignment.repo.ProductRepository;
import com.example.assignment.request.entity.*;

@Service
public class AssignmentService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public Product insertProduct(Product product) {
		
		product.setCreatedAt(LocalDateTime.now());

		return productRepository.save(product);
//		return productRepository.findById(product.getId()).get();
		
	}


	public List<Product> findProduct(String category,int page,int size) {
		return productRepository.findByCategoryOrderByCreatedAtDesc(category,PageRequest.of(page, size));
	}

	
}
