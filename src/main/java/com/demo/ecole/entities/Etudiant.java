package com.demo.ecole.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "etudiants")
public class Etudiant {

    @Id
    @Column(name = "etudiant_id")
    private String id;
    private String nom;
    private String prenom;
    private String code_postal;
    private String adresse;
    private String ville;
    private String email;
    private String motpasse;
    //@ManyToMany( mappedBy = "list_etudiant",fetch = FetchType.EAGER)
    @OneToMany(mappedBy="etudiant" ,fetch = FetchType.EAGER)
    private Set<EtudiantMatire> list_matiere= new HashSet<>();
    @ManyToOne
    private Classe classe;



}
