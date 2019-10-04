package com.orderAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderAux {

    @JsonProperty("idClient")
    private int idClient;
    @JsonProperty("idProduct")
    private Integer[] idProduct;
    @JsonProperty("address")
    private Address address;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Integer[] getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer[] idProduct) {
        this.idProduct = idProduct;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
}
