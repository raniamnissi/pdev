package tn.esprit.tn.esprit.services;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Employe;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;

@Remote
public interface ChefDepartementInterfaceRemote {
	public List<Etudiant> afficherEtudiant();
	public List<Archive> afficher(Etudiant e) ;
	public void ajouterUtilisateur(Archive entity);
	public List<Etudiant> afficherEtudiant2();
	public void ajouterUtilisateur2(Etudiant entity);
	public Etudiant getById(int id);
	public List<FichePfe> listerFicheAccParDirec(FichePfe f);
	public List<FichePfe> listerFicheAccParDirec();
	public List<FichePfe> afficherSansEncad();
	public List<FichePfe> afficherSansRap();
	public List<FichePfe> afficherFicheSanNote();
	public void affecterFicheEncadrant(int iFi,Employe iEns);
	public void ajouterEnsei(Employe e);
	public void modifierFiches(int id,String msg);
    public List<Employe> employes ();
    public List<Etudiant> etudiants ();
    public void affecterRapporteurRania(int idFiche,int idEnsei) ;
    public Long afficherNbdesEtudiantsAff(int idRap);
    public List<Employe> affichertouslesRap();
    public void affecterEncadRania(int idFiche,int idEncad) ; 
	
}
