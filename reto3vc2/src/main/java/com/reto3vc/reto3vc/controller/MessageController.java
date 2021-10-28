/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.controller;

import com.reto3vc.reto3vc.entity.Message;
import com.reto3vc.reto3vc.service.MessageService;
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
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService service;
    
    @GetMapping("/all")
    public List<Message> findAllMessage(){
        return service.getMessageAll();
    }
    
     @GetMapping("Get/{id}")    
    public Message findMessageById(@PathVariable int id){
         return service.getMessageById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity addMessage(@RequestBody Message message){
        service.saveMessageAll(message);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateMessage(@RequestBody Message message){
        service.updateMessage(message);
        return ResponseEntity.status(201).build();
    }    

    @DeleteMapping("/delete")    
        public ResponseEntity deleteMessage(@RequestBody Message message){
        service.deleteMessage(message.getIdMessage());
        return ResponseEntity.status(204).build();
    }
        
        
    @DeleteMapping("/{id}")    
    public ResponseEntity deleteMessage1(@PathVariable int id){
    service.deleteMessage(id);
    return ResponseEntity.status(204).build();
    }
}

