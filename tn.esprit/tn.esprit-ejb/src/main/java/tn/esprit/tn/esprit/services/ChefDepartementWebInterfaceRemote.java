package tn.esprit.tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;

@Remote
public interface ChefDepartementWebInterfaceRemote {
	public List<FichePfe> findAllMarks();
	public List<Archive> afficher(Etudiant e);
	public List<Etudiant> afficherEtudiant() ;

}
