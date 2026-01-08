package org.xproce.projet.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="trip")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startCity;
    private String endCity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    private Double price;
    private Integer placeAvail;
    @OneToMany(mappedBy = "trip", fetch=FetchType.LAZY)
    private Collection<Reservation> reservations;
    @ManyToOne
    private User conductor;
}
