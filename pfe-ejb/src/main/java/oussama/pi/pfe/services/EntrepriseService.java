package oussama.pi.pfe.services;

import java.awt.List;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import oussama.pi.pfe.persistence.Categorie;
import oussama.pi.pfe.persistence.Entreprise;
import oussama.pi.pfe.persistence.Etudiant;

@Stateless
@LocalBean
public class EntrepriseService  implements EntrepriseServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;

	public EntrepriseService() {
		super();
		
	}
	
	public void addEntreprise(Entreprise e){
		entityManager.persist(e);
	}
	public ArrayList<Entreprise> getAll(){
		TypedQuery<Entreprise> query=entityManager.createQuery("Select p from Entreprise p",Entreprise.class);
		return (ArrayList<Entreprise>) query.getResultList();
	}
	public ArrayList<Entreprise> getbyName(String nom){
		TypedQuery<Entreprise> query=entityManager.createQuery("Select p from Entreprise p Where p.nom='"+nom+"'",Entreprise.class);
		return (ArrayList<Entreprise>) query.getResultList();
	}
	public Entreprise getEntre(String username,String password){
		Entreprise f=new Entreprise();
		try {
			TypedQuery<Entreprise> query=entityManager.createQuery("Select p from Entreprise p Where p.usernameRH='"+username+"' AND p.passwordRH='"+password+"'",Entreprise.class);
			//query.setParameter("id", id);
		
			
			f= query.getSingleResult();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
		
	}
	
	
}
