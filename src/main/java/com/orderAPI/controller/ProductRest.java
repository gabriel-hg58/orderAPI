package com.orderAPI.controller;

import com.orderAPI.model.Product;
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
@RequestMapping(value = "/produto")
public class ProductRest {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public List<Product> productList() {
        return productService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> findProduct(@PathVariable int id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productService.save(product);
            return "Produto salvo com sucesso!";
        } catch (Exception e) {
            return "Ocorreu um erro ao salvar o produto";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.save(product);
        return updatedProduct;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id) {
        try {
            productService.deleteById(id);
            return "Produto removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover o produto";
        }
    }
}
