package com.orderAPI.controller;

import com.orderAPI.model.ClientData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.orderAPI.service.ClientDataService;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "cliente")
public class ClientRest {

    @Autowired
    private ClientDataService clientService;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public List<ClientData> clientList() {
        return clientService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ClientData> findClient(@PathVariable int id) {
        return clientService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addClient(@RequestBody ClientData client) {
        try {
            ClientData savedClient = clientService.save(client);
            return "Cliente salvo com sucesso!";
        } catch (Exception e) {
            return "Ocorreu um erro ao salvar o cliente";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ClientData updateClient(@RequestBody ClientData client) {
        ClientData updatedClient = clientService.save(client);
        return updatedClient;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteClient(@PathVariable int id) {
        try {
            clientService.deleteById(id);
            return "Cliente removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover o cliente";
        }
    }
}
