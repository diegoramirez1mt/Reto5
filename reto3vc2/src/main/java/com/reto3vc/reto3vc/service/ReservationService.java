/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.service;
import com.reto3vc.reto3vc.entity.Reservation;
import com.reto3vc.reto3vc.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public Reservation saveReservationAll(Reservation reservation){
        return repository.save(reservation);
    }

    public List<Reservation> getReservationAll(){
        return repository.findAll();
    }

    public Reservation getReservationById(int id){
        return repository.findById(id).orElse(null);
    } 
    
    public Reservation updateReservation(Reservation reservation){
        Reservation existeReservation=repository.findById(reservation.getIdReservation()).orElse(null);
        existeReservation.setStartDate(reservation.getStartDate());
        existeReservation.setDevolutionDate(reservation.getDevolutionDate());
        return repository.save(existeReservation);
    }

    public String deleteReservation(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    }
}

