package com.demo.ecole.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "matiere")
public class Matiere {

    @Id
    @Column(name = "matiere_id")
    private String id;
    private String nom;
    private int coef;
    //@ManyToMany( fetch = FetchType.EAGER)
    @OneToMany(mappedBy="matiere" ,fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<EtudiantMatire> list_etudiant=new HashSet<>();
    @ManyToMany( fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Professeur> list_professeur=new HashSet<>();





}
