package com.jps.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jps.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	 List<Product> findProductByBrand(String brand);
	 List<Product>  findProductBySize(String size);
	 
	 List<Product>  findProductByPrice(Double price);
	 List<Product>  findProductByColor(String color);
	 
	 List<Product>  getBySku(String sku);

}
