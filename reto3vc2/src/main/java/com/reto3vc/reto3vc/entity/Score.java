package com.reto3vc.reto3vc.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Camilo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="score")
public class Score implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int calificacion;
    
     @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

}
