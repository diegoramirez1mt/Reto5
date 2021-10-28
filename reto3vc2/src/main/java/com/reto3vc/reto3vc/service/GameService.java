/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.service;

import com.reto3vc.reto3vc.entity.Game;
import com.reto3vc.reto3vc.repository.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo
 */
@Service
public class GameService {
      @Autowired
    private GameRepository repository;
    
    public Game saveGameAll(Game game){
        return repository.save(game);
    }
    
    public List<Game> getGameAll(){
        return repository.findAll();
    }

    public Game getGameById(int id){
        return repository.findById(id).orElse(null);
    }     
   
    public Game UpdateGame(Game game){
        Game existeGame=repository.findById(game.getId()).orElse(null);
        existeGame.setName(game.getName());
        existeGame.setDeveloper(game.getDeveloper());
        existeGame.setYear(game.getYear());
        existeGame.setDescription(game.getDescription());
        return repository.save(existeGame);
    }
    
    public String deleteGame(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    }
    
}
