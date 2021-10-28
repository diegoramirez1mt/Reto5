/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.controller;

import com.reto3vc.reto3vc.entity.Category;
import com.reto3vc.reto3vc.service.CategoryService;
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
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService service;
    
    @GetMapping("/all")
    public List<Category> findAllCategory(){
        return service.getCategoryAll();    
    }
    
    @GetMapping("Get/{id}")    
    public Category findCategoryById(@PathVariable int id){
         return service.getCategoryById(id);
    }
    
    
    
    @PostMapping("/save")
    public ResponseEntity addCategory(@RequestBody Category category){
        service.saveCategoryAll(category);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.UpdateCategory(category);
        return ResponseEntity.status(201).build();
    }    

    @DeleteMapping("/delete")    
        public ResponseEntity deleteCategory(@RequestBody Category category){
        service.deleteCategory(category.getId());
        return ResponseEntity.status(204).build();
    }
        
    @DeleteMapping("/{id}")    
    public ResponseEntity deleteCategory1(@PathVariable int id){
    service.deleteCategory(id);
    return ResponseEntity.status(204).build();
    }
}
