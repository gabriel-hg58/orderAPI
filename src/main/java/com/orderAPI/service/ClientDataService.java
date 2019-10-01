package com.orderAPI.service;

import com.orderAPI.model.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDataService extends JpaRepository<ClientData, Integer>{
}
