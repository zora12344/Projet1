package com.demo.ecole.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="etud_matiere")
public class EtudiantMatire {
    @Id
    @Column(name = "etud_matiere_id")
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etudiant_id")
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Etudiant etudiant;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "matiere_id")
    @ToString.Exclude
    //@JsonIgnore
    @EqualsAndHashCode.Exclude
    private Matiere matiere;
    private double note;
}
