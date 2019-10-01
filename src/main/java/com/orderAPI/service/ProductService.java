package com.orderAPI.service;

import com.orderAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductService extends JpaRepository<Product, Integer>{
}
