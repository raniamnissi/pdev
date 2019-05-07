package orange;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import director.persistence.agenceassurance;
import tn.esprit.exam_device.services.agenceservice;

@ManagedBean(name="ag")
@SessionScoped
public class agcassuranceBean {


	public agcassuranceBean() {
		super();
		// TODO Auto-generated constructor stub
	}








	public int idAgence;
	public String NameAgence;
	public String descriptionAgence;
	public String ImageAgence;
	public int NbrUser;
	private List<agenceassurance> agaences;
	
    public agcassuranceBean(List<agenceassurance> agaences) {
		super();
		this.agaences = agaences;
	}
	public int getIdAgence() {
		return idAgence;
	}
	public List<agenceassurance> getAgaences() {
		agaences = agenceservicet.afficheagences();
		return agaences;
	}
	public void setAgaences(List<agenceassurance> agaences) {
		this.agaences = agaences;
	}
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	public String getNameAgence() {
		return NameAgence;
	}
	public void setNameAgence(String nameAgence) {
		NameAgence = nameAgence;
	}
	public String getDescriptionAgence() {
		return descriptionAgence;
	}
	public void setDescriptionAgence(String descriptionAgence) {
		this.descriptionAgence = descriptionAgence;
	}
	public String getImageAgence() {
		return ImageAgence;
	}
	public void setImageAgence(String imageAgence) {
		ImageAgence = imageAgence;
	}
	public int getNbrUser() {
		return NbrUser;
	}
	public void setNbrUser(int nbrUser) {
		NbrUser = nbrUser;
	}

	
	
    
	



	@Override
	public String toString() {
		return "agcassuranceBean [idAgence=" + idAgence + ", NameAgence=" + NameAgence + ", descriptionAgence="
				+ descriptionAgence + ", ImageAgence=" + ImageAgence + ", NbrUser=" + NbrUser + ", agaences=" + agaences
				+ "]";
	}








	@EJB
	agenceservice agenceservicet;
	
	
		
	public String addAgenceass() {
		String navigateTo = "";
		System.out.print("rrrrrr");
		agenceservicet.addagence(new agenceassurance(NameAgence,descriptionAgence,ImageAgence));
		navigateTo="/affichagence?faces-redirect=true";
		return navigateTo
				;}
	

	
	public void affAgenceass() {
		agaences = agenceservicet.afficheagences();
		
		}
	
	  
    public void deleteagenceass(int id)
    {
    	agenceservicet.deleteagence(id);
    	
    }
	
	
	
}