package com.orderAPI.service;

import com.orderAPI.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryService extends JpaRepository<Delivery, Integer>{
}
