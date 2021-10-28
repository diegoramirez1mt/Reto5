/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.controller;

import com.reto3vc.reto3vc.entity.Score;
import com.reto3vc.reto3vc.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService service;
    
    @GetMapping("/all")
    public List<Score> findAllScore(){
        return service.getScoreAll();
    }
    
    @GetMapping("Get/{id}")    
    public Score findScoreById(@PathVariable int id){
         return service.getScoreById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity addScore(@RequestBody Score score){
        service.saveScoreAll(score);
        return ResponseEntity.status(201).build();
    }

}
