package com.jps.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jps.model.Product;
import com.jps.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class FilterController {
	@Autowired
	ProductService productService;
	
	
	
	// get product by brand
	@GetMapping("/{brandName}")
	public List<Product> getProductByBrandName(@PathVariable String brandName) {
		return productService.getProductByBrand(brandName);
	
	}

	
	// get product by size
	@GetMapping("size/{size}")
	public List<Product> getProductBySize(@PathVariable String size) {
		return productService.getProductBySize(size);
	
	}
	
	// product Product by color
	@GetMapping("color/{color}")
	public List<Product> getProductByColor(@PathVariable String color) {
		return productService.getProductByColor(color);
	
	}
	
	// get product by size
	@GetMapping("price/{price}")
	public List<Product> getProductByPrice(@PathVariable Double price) {
		return productService.getProductByPrice(price);
	
	}
	
	// get by SKU
	@GetMapping("sku/{sku}")
	public List<Product> getProductBySku(@PathVariable String sku) {
		return productService.getBySku(sku);
	
	}
}
