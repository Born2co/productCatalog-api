package com.jps.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jps.model.Product;
import com.jps.service.ProductService;
import com.jps.service.ValidationErrorService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ValidationErrorService validationErrorService;

	@PostMapping("")
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, BindingResult result) {
		ResponseEntity<?> errorMap = validationErrorService.validate(result);
		if (errorMap != null) {
			return errorMap;
		}
		Product product1 = productService.addProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
	}

    //all products
	@GetMapping("/all")
	public Iterable<Product> getProduct() {
		return productService.getProducts();
	}

	// single products
	@GetMapping("/{prodId}")
	public ResponseEntity<?> getProductById(@PathVariable Long prodId) {
		Product product = productService.getProductById(prodId).get();
		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}
	
	// single products
//	@GetMapping("/{brandName}")
//	public Iterable<Product> getProductByBrandName(@PathVariable String brandName) {
//		//return productService.getProductByBrand(brandName);
//		return null;
//		
//	}
}
