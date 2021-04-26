package com.itschool.productmanagement.repositories;

import com.itschool.productmanagement.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<ProductModel,Integer> {
}
