/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.service;
import com.reto3vc.reto3vc.entity.Category;
import com.reto3vc.reto3vc.repository.CategoryRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category saveCategoryAll(Category category){
        return repository.save(category);
    }    

    public List<Category> getCategoryAll(){
        return repository.findAll();
    }
    
    public Category getCategoryById(int id){
        return repository.findById(id).orElse(null);
    } 

    public Category UpdateCategory(Category category){
        Category existeCategory=repository.findById(category.getId()).orElse(null);
        existeCategory.setDescription(category.getDescription());
        existeCategory.setName(category.getName());
        //existeCategory.setGame(category.getGame());
        return repository.save(existeCategory);
    }

    public String deleteCategory(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    }
}

