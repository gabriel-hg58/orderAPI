package com.orderAPI.service;

import com.orderAPI.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDataService extends JpaRepository<OrderData, Integer>{
}
