package com.demo.ecole.services;

import com.demo.ecole.entities.*;
import com.demo.ecole.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class MyService {

    private EtudiantRepository etudiantRepository;
    private MatiereRepository matiereRepository;
    private ProfesseurRepository professeurRepository;
    private ClasseRepository classeRepository;
    private MatiereEtudiantRepository matiereEtudiantRepository;

    public Etudiant ajouterEtudiant(Etudiant e){
        e.setId(UUID.randomUUID().toString());
        return etudiantRepository.save(e);
    }

    public Matiere ajouterMatiere(Matiere m){
        m.setId(UUID.randomUUID().toString());
        return matiereRepository.save(m);
    }

    public Classe ajouterClasse(Classe c){
        c.setId(UUID.randomUUID().toString());
        return classeRepository.save(c);
    }

    public Professeur ajouterProfesseur(Professeur p){
        p.setId(UUID.randomUUID().toString());
        return professeurRepository.save(p);
    }

    public EtudiantMatire ajouterEtudiantMatiere(EtudiantMatire em){
        em.setId(UUID.randomUUID().toString());
        return matiereEtudiantRepository.save(em);
    }


    public void ajouterMatiereToEtudiant(String email, String matiere,double note){
        Etudiant e = etudiantRepository.findByEmail(email);
        Matiere m = matiereRepository.findByNom(matiere);
        EtudiantMatire em = new EtudiantMatire();
        em.setEtudiant(e);
        em.setMatiere(m);
        em.setNote(note);
        EtudiantMatire emm = ajouterEtudiantMatiere(em);
        e.getList_matiere().add(emm);
        m.getList_etudiant().add(emm);

    }

    public void ajouterClasseToEtudiant(String email, String classe){
        Etudiant e = etudiantRepository.findByEmail(email);
        Classe c = classeRepository.findByNom(classe);
        e.setClasse(c);
        c.getList_etudiant().add(e);
    }

    public void ajouterMatiereToProfesseur(String email, String matiere){
        Professeur p = professeurRepository.findByEmail(email);
        Matiere m = matiereRepository.findByNom(matiere);
        p.getList_matiere().add(m);
        m.getList_professeur().add(p);

    }

    public void ajouterClasseToProfesseur(String email, String classe){
        Professeur p = professeurRepository.findByEmail(email);
        Classe c = classeRepository.findByNom(classe);
        p.getList_classe().add(c);
        c.getList_professeur().add(p);

    }

    public List<Classe> findAllClasses(){
        return classeRepository.findAll();
    }

    public List<Matiere> findAllMatieres(){
        return matiereRepository.findAll();
    }
    public Etudiant findEtudiantByEmail(String email){
        return etudiantRepository.findByEmail(email);
    }
    public List<Etudiant> findAllStudents(){
        return etudiantRepository.findAll();
    }

    public EtudiantMatire findEtudiantMatiereByEtudiantidAndMatiereid(String etudiantid, String matiere){
        Etudiant e = etudiantRepository.findById(etudiantid).get();
        Matiere m = matiereRepository.findByNom(matiere);
        return matiereEtudiantRepository.findByEtudiantAndMatiere(e,m).get(0);


    }

    public Professeur findProffesseurByEmail(String email){
        return professeurRepository.findByEmail(email);
    }

    public void updateNoteEtudiantMatiere(String etudiantid, String matiere, String note){
        EtudiantMatire em = findEtudiantMatiereByEtudiantidAndMatiereid(etudiantid,matiere);
        em.setNote(Double.parseDouble(note));
    }

    public void insertIntoEtudiantMatiere(String etudiant, String matiere, String note){
        EtudiantMatire em = new EtudiantMatire();
        em.setId(UUID.randomUUID().toString());
        em.setNote(Double.parseDouble(note));
        Matiere m = matiereRepository.findByNom(matiere);
        em.setMatiere(m);
        String[] nomcomplet = etudiant.split(" ");
        Etudiant e = etudiantRepository.findByNomAndPrenom(nomcomplet[0], nomcomplet[1]);
        em.setEtudiant(e);
        ajouterEtudiantMatiere(em);
    }

    public void deletenote(String idMatiereEtudiant){
        EtudiantMatire em = matiereEtudiantRepository.findById(idMatiereEtudiant).get();
        matiereEtudiantRepository.delete(em);
    }

    public List<Etudiant> findEtudiantsByClasseName(String classeName){
        Classe c = classeRepository.findByNom(classeName);
        return etudiantRepository.findByClasse(c);
    }

    public Etudiant findStudentByEmailAndMotpasse(String email, String pass){
        return etudiantRepository.findByEmailAndMotpasse(email,pass);
    }

    public Professeur findProfByEmailAndMotpasse(String email, String pass){
        return professeurRepository.findByEmailAndMotpasse(email,pass);
    }
}
