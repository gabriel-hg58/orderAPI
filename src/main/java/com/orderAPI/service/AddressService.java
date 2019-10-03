package com.orderAPI.service;

import com.orderAPI.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressService extends JpaRepository<Address, Integer>{
}
