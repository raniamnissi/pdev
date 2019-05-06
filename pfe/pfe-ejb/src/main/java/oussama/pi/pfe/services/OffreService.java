package oussama.pi.pfe.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import oussama.pi.pfe.persistence.Entreprise;
import oussama.pi.pfe.persistence.Offre;

@Stateless
@LocalBean
public class OffreService implements OffreServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createOffre(Offre o) {
	     entityManager.persist(o);
	}

	@Override
	public ArrayList<Offre> afficherOffre() {
		TypedQuery<Offre> query=entityManager.createQuery("Select p from Offre p Where auto=1",Offre.class);
		return (ArrayList<Offre>) query.getResultList();
	}

	@Override
	public ArrayList<Offre> affihcerMesOffre(int id) {
		TypedQuery<Offre> query=entityManager.createQuery("Select p from Offre p WHERE idEntre="+id,Offre.class);
		return (ArrayList<Offre>) query.getResultList();
	}

}
