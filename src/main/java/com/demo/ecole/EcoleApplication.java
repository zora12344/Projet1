package com.demo.ecole;

import com.demo.ecole.entities.Classe;
import com.demo.ecole.entities.Etudiant;
import com.demo.ecole.entities.Matiere;
import com.demo.ecole.entities.Professeur;
import com.demo.ecole.services.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EcoleApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcoleApplication.class, args);
	}

	@Bean
	CommandLineRunner start(MyService etudiantService){
		return args -> {
			Etudiant etudiantA = new Etudiant();
			etudiantA.setNom("Mica");
			etudiantA.setPrenom("Alex");
			etudiantA.setAdresse("etudBadresse");
			etudiantA.setCode_postal("etudBcd_postale");
			etudiantA.setEmail("etudeBmail");
			etudiantA.setVille("etudBville");
			etudiantA.setMotpasse("etudBpasswd");
			Etudiant etudiantB = new Etudiant();
			etudiantB.setNom("Dupond");
			etudiantB.setPrenom("Elodie");
			etudiantB.setAdresse("etudAadresse");
			etudiantB.setCode_postal("etudAcd_postale");
			etudiantB.setEmail("etudeAmail");
			etudiantB.setVille("etudAville");
			etudiantB.setMotpasse("etudApasswd");

			etudiantService.ajouterEtudiant(etudiantA);
			etudiantService.ajouterEtudiant(etudiantB);



			Matiere matiereA = new Matiere();
			matiereA.setNom("Math");
			matiereA.setCoef(7);
			Matiere matiereB = new Matiere();
			matiereB.setNom("Physique");
			matiereB.setCoef(8);
			Matiere matiereC = new Matiere();
			matiereC.setNom("Chimique");
			matiereC.setCoef(9);
			Matiere matiereD = new Matiere();
			matiereD.setNom("Svt");
			matiereD.setCoef(10);

			etudiantService.ajouterMatiere(matiereA);
			etudiantService.ajouterMatiere(matiereB);
			etudiantService.ajouterMatiere(matiereC);
			etudiantService.ajouterMatiere(matiereD);


			Classe classeA = new Classe();
			classeA.setNom("classeA");
			Classe classeB= new Classe();
			classeB.setNom("classeB");


			etudiantService.ajouterClasse(classeA);
			etudiantService.ajouterClasse(classeB);

			Professeur profA = new Professeur();
			profA.setNom("profAnom");
			profA.setPrenom("profAprenom");
			profA.setAdresse("profAadresse");
			profA.setCode_postal("profAcd_postale");
			profA.setEmail("profAemail");
			profA.setVille("profAville");
			profA.setMotpasse("profApasswd");

			Professeur profB = new Professeur();
			profB.setNom("profBnom");
			profB.setPrenom("profBprenom");
			profB.setAdresse("profBadresse");
			profB.setCode_postal("profBcd_postale");
			profB.setEmail("profBemail");
			profB.setVille("profBville");
			profB.setMotpasse("profBpasswd");

			etudiantService.ajouterProfesseur(profA);
			etudiantService.ajouterProfesseur(profB);


			etudiantService.ajouterClasseToEtudiant("etudeBmail", "classeA");
			etudiantService.ajouterClasseToEtudiant("etudeAmail", "classeB");

			etudiantService.ajouterMatiereToEtudiant("etudeAmail", "Math", 11);
			etudiantService.ajouterMatiereToEtudiant("etudeAmail", "Physique",12);
			etudiantService.ajouterMatiereToEtudiant("etudeAmail", "Chimique",13);
			etudiantService.ajouterMatiereToEtudiant("etudeBmail", "Svt",14);
			etudiantService.ajouterMatiereToEtudiant("etudeBmail", "Chimique",15);

			etudiantService.ajouterMatiereToProfesseur("profAemail", "Math");
			etudiantService.ajouterMatiereToProfesseur("profAemail", "Physique");
			etudiantService.ajouterMatiereToProfesseur("profAemail", "Chimique");
			etudiantService.ajouterMatiereToProfesseur("profBemail", "Svt");
			etudiantService.ajouterMatiereToProfesseur("profBemail", "Chimique");

			etudiantService.ajouterClasseToProfesseur("profAemail", "classeA");
			etudiantService.ajouterClasseToProfesseur("profAemail", "classeA");
			etudiantService.ajouterClasseToProfesseur("profBemail", "classeB");
			etudiantService.ajouterClasseToProfesseur("profBemail", "classeB");





			Etudiant e = etudiantService.findEtudiantByEmail("etudeBmail");
			System.out.println("voici la liste des matière du monsieur :"+e.getNom());
			//e.getList_matiere().stream().forEach(s->System.out.println(s.getNom()));
			e.getList_matiere().stream().forEach(et -> System.out.println(et.getMatiere().getNom()));

			//Professeur p = etudiantService.findProffesseurByEmail("profBemail");
			//System.out.println(p.getNom());
			//p.getList_matiere().stream().forEach(s->System.out.println(s.getNom()));

		};
	}
}
