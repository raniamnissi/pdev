package tn.esprit.tn.esprit.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Employe;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;



@Remote
public interface FicheServiceRemote {
	 public void creefiche(FichePfe p);
	 public FichePfe afficher(int id); 
	 public Etudiant reup(int id);
	 public Employe donn(int id);

	 public void modifierMaj(FichePfe p,int id,String date);
	 public void modifierMin(FichePfe p,int id, String date);
	 public void creeArchive(Archive arch);
	 public FichePfe reupFiche(int id) ;
	 public ArrayList reupCat();
		public Employe getByIdEmploye(int idEmploye);

}
