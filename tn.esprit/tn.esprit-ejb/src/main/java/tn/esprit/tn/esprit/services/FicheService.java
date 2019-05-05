package tn.esprit.tn.esprit.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Categorie;
import tn.esprit.esprit.entities.Employe;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;

@Stateless
public class FicheService implements FicheServiceRemote {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void creefiche(FichePfe p) {
		entityManager.persist(p);
	}

	@Override
	public FichePfe afficher(int id) {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where etudiant_ID="+id,FichePfe.class);
		//query.setParameter("id", id);
		FichePfe f= new FichePfe();
		f= query.getSingleResult();
		return f;
	}

	@Override
	public Etudiant reup(int id) {
		TypedQuery<Etudiant> query=entityManager.createQuery("Select p from Etudiant p Where ID="+id,Etudiant.class);
		//query.setParameter("id", id);
	
		Etudiant f= new Etudiant();
		f= query.getSingleResult();
		return f;
	}

	@Override
	public Employe donn(int id) {
		TypedQuery<Employe> query=entityManager.createQuery("Select p from Employe p Where ID="+id,Employe.class);
		//query.setParameter("id", id);
	
		Employe f= new Employe();
		f= query.getSingleResult();
		return f;
	}

	@Override
	public void modifierMaj(FichePfe p, int id, String date) {
		int query=entityManager.createQuery("UPDATE FichePfe SET anneeFiche='"+date+"',categFiche='"+p.getCategFiche()+"',descriptionFiche='"+p.getDescriptionFiche()+"',ecoleFiche='"+p.getEcoleFiche()+"',entrepFiche='"+p.getEntrepFiche()+"',nouvfctFiche='"+p.getFctFiche()+"',motCleFiche='"+p.getMotCleFiche()+"',paysFiche='"+p.getPaysFiche()+"',nouvprobleFiche='"+p.getProbleFiche()+"',titreFiche='"+p.getTitreFiche()+"', version="+p.getVersion()+"WHERE ID="+id).executeUpdate();   
		
	}

	@Override
	public void modifierMin(FichePfe p, int id, String date) {
		int query=entityManager.createQuery("UPDATE FichePfe SET anneeFiche='"+date+"',categFiche='"+p.getCategFiche()+"',descriptionFiche='"+p.getDescriptionFiche()+"',ecoleFiche='"+p.getEcoleFiche()+"',entrepFiche='"+p.getEntrepFiche()+"',motCleFiche='"+p.getMotCleFiche()+"',paysFiche='"+p.getPaysFiche()+"',titreFiche='"+p.getTitreFiche()+"',version="+p.getVersion()+" WHERE ID="+id).executeUpdate();   
		
	}

	@Override
	public void creeArchive(Archive arch) {
		entityManager.persist(arch);		
	}

	@Override
	public FichePfe reupFiche(int id) {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where ID="+id,FichePfe.class);
		//query.setParameter("id", id);
	
		FichePfe f= new FichePfe();
		f= query.getSingleResult();
		return f;
	}

	@Override
	public ArrayList reupCat() {
		TypedQuery<Categorie> query=entityManager.createQuery("Select p from Categorie p",Categorie.class);
		//query.setParameter("id", id);
		ArrayList results= (ArrayList) query.getResultList();
		
		
		return results;
	}
	@Override
	public Employe getByIdEmploye(int idEmploye) {
		// TODO Auto-generated method stub
		return entityManager.find(Employe.class,idEmploye);
	}


}
