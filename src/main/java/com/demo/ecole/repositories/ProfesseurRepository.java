package com.demo.ecole.repositories;

import com.demo.ecole.entities.Etudiant;
import com.demo.ecole.entities.Matiere;
import com.demo.ecole.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, String> {

    Professeur findByEmail(String email);
    Professeur findByEmailAndMotpasse(String email, String motpasse);
}
