package org.xproce.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.stereotype.Controller;
import org.xproce.projet.dao.entities.Trip;
import org.xproce.projet.dao.entities.User;
import org.xproce.projet.dao.repositories.UserRepository;
import org.xproce.projet.dao.repositories.TripRepository;
import org.xproce.projet.dao.repositories.ReservationRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.xproce.projet.dao.repositories")
@EntityScan(basePackages = "org.xproce.projet.dao.entities")
public class ProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserRepository userRepo,
                            TripRepository tripRepo,
                            ReservationRepository reservationRepo) {
        return args -> {

            User conductor = new User();
            conductor.setName("Ahmed");
            conductor.setEmail("ahmed@test.com");
            conductor.setPassword("1234");
            userRepo.save(conductor);



            Trip t1 = new Trip(null, "Casablanca", "Marrakech", new java.util.Date(), 200.0, 15, null, conductor);
            Trip t2 = new Trip(null, "Rabat", "Tanger", new java.util.Date(), 150.0, 10, null, conductor);

            tripRepo.save(t1);
            tripRepo.save(t2);

            System.out.println("Données insérées avec succès !");
        };
    }



}
