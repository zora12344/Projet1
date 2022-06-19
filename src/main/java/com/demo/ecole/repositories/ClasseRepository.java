package com.demo.ecole.repositories;

import com.demo.ecole.entities.Classe;
import com.demo.ecole.entities.Etudiant;
import com.demo.ecole.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, String> {

    Classe findByNom(String name);

}
