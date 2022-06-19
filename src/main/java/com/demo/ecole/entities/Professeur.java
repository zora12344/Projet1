package com.demo.ecole.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Professeur {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String code_postal;
    private String adresse;
    private String ville;
    private String email;
    private String motpasse;
    @ManyToMany( mappedBy = "list_professeur",fetch = FetchType.EAGER)
    private Set<Matiere> list_matiere= new HashSet<>();
    @ManyToMany( mappedBy = "list_professeur",fetch = FetchType.EAGER)
    private Set<Classe> list_classe= new HashSet<>();


}
