package com.orderAPI.controller;

import com.orderAPI.model.OrderData;
import com.orderAPI.service.AddressService;
import com.orderAPI.service.OrderDataService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedido")
public class OrderRest {

    @Autowired
    private OrderDataService orderService;
    
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public List<OrderData> orderList() {
        return orderService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<OrderData> findOrder(@PathVariable int id) {
        return orderService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addOrder(@RequestBody OrderData order) {
        try {
            OrderData savedOrder = orderService.save(order);
            return "Pedido salvo com sucesso!";
        } catch (Exception e) {
            return "Ocorreu um erro ao salvar o pedido";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public OrderData updateOrder(@RequestBody OrderData order) {
        OrderData updatedOrder = orderService.save(order);
        return updatedOrder;
    }
}
