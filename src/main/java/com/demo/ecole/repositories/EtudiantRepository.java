package com.demo.ecole.repositories;

import com.demo.ecole.entities.Classe;
import com.demo.ecole.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, String> {

    Etudiant findByEmail(String email);
    List<Etudiant> findByClasse(Classe classeName);
    Etudiant findByNomAndPrenom(String nom, String prenom);
    Etudiant findByEmailAndMotpasse(String email, String motpasse);
}
