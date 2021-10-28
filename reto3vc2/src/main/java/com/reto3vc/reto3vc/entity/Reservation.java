package com.reto3vc.reto3vc.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    private Calendar startDate;
    private Calendar devolutionDate;
    private String status="created";
    //@OneToOne    
    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnoreProperties("reservations")
    //@JsonIgnoreProperties({"reservations","game"})
    private Game game;
    
    
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservation")
    //@JoinColumn(name = "score_id")
    @JsonIgnoreProperties("reservation")
    //@JsonIgnoreProperties({"client","game","messages","reservations"})
    private Score score;
    //private Client client;    
}
