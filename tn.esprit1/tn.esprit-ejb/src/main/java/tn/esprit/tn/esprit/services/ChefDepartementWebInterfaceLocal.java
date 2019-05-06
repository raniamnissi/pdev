package tn.esprit.tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;

@Local
public interface ChefDepartementWebInterfaceLocal {
	public List<FichePfe> findAllMarks();
	public List<Archive> afficher(Etudiant e);

}
