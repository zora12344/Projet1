package com.demo.ecole.repositories;

import com.demo.ecole.entities.Etudiant;
import com.demo.ecole.entities.EtudiantMatire;
import com.demo.ecole.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MatiereEtudiantRepository extends JpaRepository<EtudiantMatire, String> {

    List<EtudiantMatire> findByEtudiantAndMatiere(Etudiant e, Matiere m);

   Set<EtudiantMatire> findByEtudiant(Etudiant e);

    Set<EtudiantMatire> findByMatiere(Matiere m);


}
