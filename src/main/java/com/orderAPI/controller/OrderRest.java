package com.orderAPI.controller;

import com.orderAPI.model.Address;
import com.orderAPI.model.ClientData;
import com.orderAPI.model.OrderAux;
import com.orderAPI.model.OrderData;
import com.orderAPI.model.Product;
import com.orderAPI.service.AddressService;
import com.orderAPI.service.ClientDataService;
import com.orderAPI.service.OrderDataService;
import com.orderAPI.service.ProductService;
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

    @Autowired
    private ClientDataService clientService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public List<OrderData> orderList() {
        return orderService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<OrderData> findOrder(@PathVariable int id) {
        return orderService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addOrder(@RequestBody OrderAux order) {
//        OrderData orderData = new OrderData();
//        orderData.setIdOrder(0);
//        Address address;
//        Optional<ClientData> clientData = clientService.findById(order.getIdClient());
//        Optional<Product> product = null;
//
//        try {
//            address = addressService.save(order.getAddress());
//            orderData.setAddress(address);
//            orderData.setClientData(clientData.get());
//            for (int i = 0; i < order.getIdProduct().length; i++) {
//                product = productService.findById(i);
//                orderData.setProduct(product.get());
//                orderData.setAmount(orderData.getAmount().add(product.get().getProductValue()));
//            }
//            System.out.println("Pedido criado rapaz");
//        } catch (Exception e) {
//            System.out.println("Não foi possivel criar o pedido");
//        }

        return order.toString();
//        try {
//            OrderData savedOrder = orderService.save(order);
//            return "Pedido salvo com sucesso!";
//        } catch (Exception e) {
//            return "Ocorreu um erro ao salvar o pedido";
//        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public OrderData updateOrder(@RequestBody OrderData order) {
        OrderData updatedOrder = orderService.save(order);
        return updatedOrder;
    }
}
