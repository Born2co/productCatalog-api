package com.jps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jps.exception.BrandNotFoundException;
import com.jps.exception.IdNotFoundException;
import com.jps.model.Product;
import com.jps.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	// add or save
	public Product addProduct(Product product) {
		
		if(product.getId()!=null) {
			Long id=product.getId();
			productRepository.save(product);
		}
		return productRepository.save(product);

	}

	// get all product
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}

	
	// get product by id
	public Optional<Product> getProductById(Long id) {

		Optional<Product> product = productRepository.findById(id);
		if (!product.isPresent()) {
			throw new IdNotFoundException("Project ID '" + id + "' does not exist");
		}

		return product;
	}

	// group product by brand
	public List<Product> getProductByBrand(String brandName) {
		List<Product> productByBrand = productRepository.findProductByBrand(brandName);
		if (productByBrand.isEmpty()) {
			throw new BrandNotFoundException("brand '" + brandName + "' does not exist");
		}

		return productByBrand;
	}

	// group product by color
	public List<Product> getProductByColor(String color) {
		List<Product> productByColour = productRepository.findProductByColor(color);
		if (productByColour.isEmpty()) {
			throw new BrandNotFoundException("color '" + color + "' does not exist");
		}
		return productByColour;
	}

	// group product by price
	public List<Product> getProductByPrice(Double price) {
		List<Product> productByPrice = productRepository.findProductByPrice(price);

		if (productByPrice.isEmpty()) {
			throw new BrandNotFoundException("price '" + price + "' does not exist");
		}

		return productByPrice;
	}

	// group product by size
	public List<Product> getProductBySize(String size) {
		List<Product> productSize = productRepository.findProductBySize(size);
		if (productSize.isEmpty()) {
			throw new BrandNotFoundException("price '" + size + "' does not exist");
		}

		return productSize;
		
		
	}
	
	// group product by size
	public List<Product> getBySku(String sku) {
		List<Product> allSku = productRepository.getBySku(sku);
		if (allSku.isEmpty()) {
			throw new BrandNotFoundException("price '" + sku + "' does not exist");
		}

		return allSku;
		
		
	}

}
