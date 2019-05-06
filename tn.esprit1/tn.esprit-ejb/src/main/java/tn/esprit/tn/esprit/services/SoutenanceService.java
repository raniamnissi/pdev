package tn.esprit.tn.esprit.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.esprit.entities.Soutenance;

@Stateless
public class SoutenanceService implements SoutannaceRemaote,SoutennaceServiceLocal {
	@PersistenceContext(unitName="tn.esprit-ejb")
	EntityManager em;
		
	@Override
	public void AddSoutanace(Soutenance soutenance) {
		em.persist(soutenance);
		
	}

	@Override
	public Soutenance AfficherSoutenance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteSoutenace(int Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Soutenance EditSoutenance(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
