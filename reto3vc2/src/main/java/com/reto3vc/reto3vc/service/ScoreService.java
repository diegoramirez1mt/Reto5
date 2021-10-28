package com.reto3vc.reto3vc.service;
import com.reto3vc.reto3vc.entity.Score;
import com.reto3vc.reto3vc.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    public Score saveScoreAll(Score score){
        return repository.save(score);
    }

    public List<Score> getScoreAll(){
        return repository.findAll();
    }
    
    public Score getScoreById(int id){
        return repository.findById(id).orElse(null);
    } 

    /*public Score updateScore(Score score){
        Score existeScore=repository.findById(score.getId()).orElse(null);
        existeScore.setCalificacion(score.getCalificacion());
        return repository.save(existeScore);
    }

    public String deleteScore(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    }*/
}
