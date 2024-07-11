package com.example.assignment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.assignment.dao.entity.Product;
import com.example.assignment.exception.ProductNotFound;
import com.example.assignment.service.AssignmentService;

@RestController
@RequestMapping("/v1/products")
public class AssignmentController {
	
	@Autowired
	private AssignmentService assignmentService;
	
	@PostMapping("/insert-product")
	public Product insertProduct(@RequestBody Product product)
	{
		return assignmentService.insertProduct(product);
	}
	
	@GetMapping("/product")
	public List<Product> findProduct(@RequestParam(name="category") String category,
			@RequestParam(name="page") int page,@RequestParam(name="size") int size) 
	{
		return assignmentService.findProduct(category,page,size);
		
	}
}

