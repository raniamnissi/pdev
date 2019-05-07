package oussama.pi.pfe.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import oussama.pi.pfe.persistence.Etudiant;


@Stateless
@LocalBean
public class EtudiantService implements EtudiantServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;
	public Etudiant getDonneEtu(int id){
		return entityManager.find(Etudiant.class,id);
	}
	public void annulation(int id,int ann,String ms){
		int query=entityManager.createQuery("UPDATE Etudiant SET annulation="+ann+", msg='"+ms+"' WHERE ID="+id).executeUpdate();   
	}
	public Etudiant getEtu(String username,String password){
		Etudiant f= new Etudiant();
		try {
			TypedQuery<Etudiant> query=entityManager.createQuery("Select p from Etudiant p Where p.userNameEtudiant='"+username+"' AND p.passwordEtudiant='"+password+"'",Etudiant.class);
			//query.setParameter("id", id);
		
			
			f= query.getSingleResult();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
		
	}
	
}
