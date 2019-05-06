package tn.esprit.tn.esprit.services;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Employe;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;

@Stateless
public class ChefDepartementService implements ChefDepartementInterfaceRemote {
	public ChefDepartementService() {
		super();
		
	}
	@PersistenceContext
	private EntityManager entityManager;
	

	  public EntityManager getEntityManager() {
	        return entityManager;
	    }

	    public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	
	//afficher les etudiants
	public List<Etudiant> afficherEtudiant() {
	
		TypedQuery<Etudiant> query=entityManager.createQuery("SELECT e FROM Etudiant e ",Etudiant.class);
		 
		return query.getResultList();
		
		
	}
	public Etudiant getById(int id) {
		TypedQuery<Etudiant> query=entityManager.createQuery("Select a from Etudiant a Where a.idEtudiant =:id",Etudiant.class);
		query.setParameter("id", id);
		return query.getSingleResult();

	}
	//aficher les fiche d'un etud donne
	public List<Archive> afficher(Etudiant e) {
		TypedQuery<Archive> query=entityManager.createQuery("Select a from Archive a Where a.etudiant =:id",Archive.class);
		query.setParameter("id", e);
	
		return query.getResultList();
	}
	//ajouter archive
	public void ajouterUtilisateur(Archive entity) {
		entityManager.persist(entity);
	}
//afficher etudiant
	@Override
	public List<Etudiant> afficherEtudiant2() {
		TypedQuery<Etudiant> query=entityManager.createQuery("SELECT e FROM Etudiant e ",Etudiant.class);
		 
		return query.getResultList();
		// TODO Auto-generated method stub
	}
//ajout etudiant
	@Override
	public void ajouterUtilisateur2(Etudiant entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);

	}
//lister les fiches acceptes par le directeur de stage 
	@Override
	public List<FichePfe> listerFicheAccParDirec(FichePfe f) {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select f from FichePfe f Where f.etatFiche =:aaaaa",FichePfe.class);
		query.setParameter("aaaaa", 1);
	
		return query.getResultList();
	}
//liset les fiche acc par direc de stage
	@Override
	public List<FichePfe> listerFicheAccParDirec() {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select f from FichePfe f Where f.etatFiche =:aaaaa",FichePfe.class);
		query.setParameter("aaaaa", 1);
	//List<Archive>f=query.getResultList();
		//Archive f= new Archive();
		//f= query.getResultList();
		return query.getResultList();
	}
//fiche sans encadrant 
	@Override
	public List<FichePfe> afficherSansEncad() {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select f from FichePfe f Where f.employesEnc = NULL",FichePfe.class);
		//query.setParameter("aaaaa",null);
	
		return query.getResultList();
		
	}
//fiches sans raporteur
	@Override
	public List<FichePfe> afficherSansRap() {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select f from FichePfe f Where f.employesRap = NULL",FichePfe.class);
		//query.setParameter("aaaaa",null);
	
		return query.getResultList();
		
	}
//fiches sans note
	@Override
	public List<FichePfe> afficherFicheSanNote() {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select f from FichePfe f Where f.noteRap =-1 and f.noteEnc=-1",FichePfe.class);
		//query.setParameter("aaaaa", -1);
		//query.setParameter("a", -1);
	//List<Archive>f=query.getResultList();
		//Archive f= new Archive();
		//f= query.getResultList();
		return query.getResultList();
	}

	@Override
	public void affecterFicheEncadrant(int iFi, Employe iEns) {
		Query query=entityManager.createQuery("Update FichePfe f Set f.employesRap=:aa  Where f.idFiche=:aaa");
		//UPDATE Student s SET s.firstName = "foo", s.lastName = "bar" WHERE s.firstName = "toto"
		query.setParameter("aaa", iFi);
		query.setParameter("aa", iEns);
		int modifies=query.executeUpdate();
		
	}
//ajouter ens
	@Override
	public void ajouterEnsei(Employe e) {
		entityManager.persist(e);
		
	}
	
	@Override
	public void modifierFiches(int id, String msg) {
		Query query=entityManager.createQuery("Update FichePfe f Set f.fctFiche=:aaa  Where f.idFiche=:idFiche");
		//UPDATE Student s SET s.firstName = "foo", s.lastName = "bar" WHERE s.firstName = "toto"
		query.setParameter("idFiche", id);
		query.setParameter("aaa", msg);
		int modifies=query.executeUpdate();
		
	}
//afficher les employes
	@Override
	public List<Employe> employes() {
		// TODO Auto-generated method stub
		TypedQuery<Employe> query=entityManager.createQuery("Select f from Employe f ",Employe.class);
		//query.setParameter("aaaaa",null);
	
		return query.getResultList();
		}

	@Override
	public List<Etudiant> etudiants() {
		// TODO Auto-generated method stub
		TypedQuery<Etudiant> query=entityManager.createQuery("Select f from Etudiant f ",Etudiant.class);
		//query.setParameter("aaaaa",null);
	
		return query.getResultList();
	}

	@Override
	public void affecterRapporteurRania(int idFiche, int idEnsei) {
		int query=entityManager.createQuery("Update FichePfe Set employesRap="+idEnsei+" Where idFiche="+idFiche).executeUpdate();
		
	}
//nretourni kol en 9adeh 3andou etudiant rap
	@Override
	public Long afficherNbdesEtudiantsAff(int idRap) {
		 /* return (int) entityManager.createNativeQuery(
	                "SELECT count(*) FROM Etudiant   WHERE  employesRap="+idRap)
	                .setParameter(1, idRap).getSingleResult();*/
		  Query query=entityManager.createQuery(" SELECT COUNT(employesRap_ID) FROM Etudiant   WHERE  employesRap="+idRap);
		  return (Long) query.getSingleResult();
		  
		 
		  //SELECT count(*) FROM Etudiant   WHERE  employesRap="+idRap
	}

	@Override
	public List<Employe> affichertouslesRap() {
		TypedQuery<Employe> query=entityManager.createQuery("SELECT e FROM Employe e ",Employe.class);
		 
		return query.getResultList();
	}
//affecttion encadrant
	@Override
	public void affecterEncadRania(int idFiche, int idEncad) {
		int query=entityManager.createQuery("Update FichePfe Set employesEnc="+idEncad+" Where idFiche="+idFiche).executeUpdate();
		
	}
	

	
	
	

	
	
	
	
}
