/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.controller;

import com.reto3vc.reto3vc.entity.Client;
import com.reto3vc.reto3vc.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Camilo
 */
@RestController 
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService service;
    
    @GetMapping("/all")
    public List<Client> findAllClient(){
        return service.getClientAll();
    }

    @GetMapping("Get/{id}")    
    public Client findClientById(@PathVariable int id){
         return service.getClientById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity addClient(@RequestBody Client client){
        service.saveClientAll(client);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client){
        service.updateClient(client);
        return ResponseEntity.status(201).build();
    }    

    @DeleteMapping("/delete")    
        public ResponseEntity deleteClient(@RequestBody Client client){
        service.deleteClient(client.getIdClient());
        return ResponseEntity.status(204).build();
    }
        
    @DeleteMapping("/{id}")    
    public ResponseEntity deleteClient1(@PathVariable int id){
    service.deleteClient(id);
    return ResponseEntity.status(204).build();
    }
}


