package com.reto3vc.reto3vc.controller;
import com.reto3vc.reto3vc.entity.Game;
import com.reto3vc.reto3vc.service.GameService;
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
@RequestMapping("/api/Game")
public class GameController {
       @Autowired
    private GameService service;
    
    @GetMapping("/all")
    public List<Game> findAllGame(){
        return service.getGameAll();
    }
    
    @GetMapping("Get/{id}")    
    public Game findGameById(@PathVariable int id){
         return service.getGameById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity addGame(@RequestBody Game game){
        service.saveGameAll(game);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateGame(@RequestBody Game game){
        service.UpdateGame(game);
        return ResponseEntity.status(201).build();
    }    

    @DeleteMapping("/delete")    
        public ResponseEntity deleteGame(@RequestBody Game game){
        service.deleteGame(game.getId());
        return ResponseEntity.status(204).build();
    } 
        
    @DeleteMapping("/{id}")    
    public ResponseEntity deleteGame1(@PathVariable int id){
    service.deleteGame(id);
    return ResponseEntity.status(204).build();}
    
}
