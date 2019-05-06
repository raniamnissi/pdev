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
	
	
}
