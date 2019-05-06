package oussama.pi.pfe.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import oussama.pi.pfe.persistence.Employe;
import oussama.pi.pfe.persistence.Etudiant;
import oussama.pi.pfe.persistence.FichePfe;

@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;
	
	public Employe getDonnEm(int id){
		return entityManager.find(Employe.class,id);
	}
	public ArrayList afficherEtudiant() {
		TypedQuery<Etudiant> query=entityManager.createQuery("Select p from Etudiant p",Etudiant.class);
		ArrayList results=(ArrayList) query.getResultList();
		return results;
	}
	public ArrayList afficherEnseignent() {
		TypedQuery<Employe> query=entityManager.createQuery("Select p from Employe p where p.employeRole='Enseignant'",Employe.class);
		ArrayList results=(ArrayList) query.getResultList();
		return results;
	}
	public void affecterEncadrant(int idEtu,int idEnsei) {
		int query=entityManager.createQuery("Update Etudiant Set employesEnc_ID="+idEnsei+" Where ID="+idEtu).executeUpdate();
	}
	public void affecterRapporteur(int idEtu,int idEnsei) {
		int query=entityManager.createQuery("Update Etudiant Set employesRappor_ID="+idEnsei+" Where ID="+idEtu).executeUpdate();
	}
	
	
	public Etudiant getEtudiant(int id){
		TypedQuery<Etudiant> query=entityManager.createQuery("Select p from Etudiant p Where employesEnc_ID="+id,Etudiant.class);
		//query.setParameter("id", id);
	
		Etudiant f= new Etudiant();
		f= query.getSingleResult();
		return f;
		
	}
	public FichePfe getFiche(int id){
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where etudiant_ID="+id,FichePfe.class);
		//query.setParameter("id", id);
	
		FichePfe f= new FichePfe();
		f= query.getSingleResult();
		return f;
		
	}
	public void accepterModif(String NouvFonc,String NouvProb,int id){
		int query=entityManager.createQuery("UPDATE FichePfe SET fctFiche='"+NouvFonc+"',probleFiche='"+NouvProb+"' WHERE ID="+id).executeUpdate();   
	}
	
	public void FavCat(int id,String fav) {
		int query=entityManager.createQuery("Update Employe Set favorie='"+fav+"' Where ID="+id).executeUpdate();
	}
}
