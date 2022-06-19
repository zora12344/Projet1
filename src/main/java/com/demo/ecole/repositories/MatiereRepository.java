package com.demo.ecole.repositories;

import com.demo.ecole.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, String> {

    Matiere findByNom(String name);
}
