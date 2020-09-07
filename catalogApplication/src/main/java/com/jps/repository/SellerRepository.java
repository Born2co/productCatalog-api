package com.jps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jps.model.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {

	

}
