/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto3vc.reto3vc.repository;

import com.reto3vc.reto3vc.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Camilo
 */
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{
    
}