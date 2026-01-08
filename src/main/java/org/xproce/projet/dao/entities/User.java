package org.xproce.projet.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Reservation> reservations;

    @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
    private Collection<Trip> trips;

}