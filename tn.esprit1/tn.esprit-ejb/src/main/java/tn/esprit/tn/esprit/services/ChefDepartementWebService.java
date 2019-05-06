package tn.esprit.tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;

/**
 * Session Bean implementation class ChefDepartementWebService
 */
@Stateless
@LocalBean
public class ChefDepartementWebService implements ChefDepartementWebInterfaceRemote, ChefDepartementWebInterfaceLocal{
	  @PersistenceContext
	    private EntityManager entityManager;
	public ChefDepartementWebService() {
		super();
		
	}

	@Override
	public List<FichePfe> findAllMarks() {
		 List<FichePfe> fiches = new ArrayList<FichePfe>();

		 fiches.addAll(entityManager.createQuery("SELECT c.nomEtudiant, c.noteRap FROM FichePfe c", FichePfe.class).getResultList());
	        return fiches;
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Archive> afficher(Etudiant e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> afficherEtudiant() {
		// TODO Auto-generated method stub
		return null;
	}


}
