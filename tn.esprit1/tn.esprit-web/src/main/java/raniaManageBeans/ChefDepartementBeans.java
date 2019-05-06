package raniaManageBeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.tn.esprit.services.ChefDepartementWebService;

@ManagedBean
@SessionScoped
public class ChefDepartementBeans {
	
    private int idFiche;
    private String titreFiche;
    private String descriptionFiche;
    private String probleFiche;
    private String fctFiche;
    private String categFiche;
    private String motCleFiche;
    private String entrepFiche;
    private int etatFiche;
    private Date anneeFiche;
    private String paysFiche;
    private String ecoleFiche;
    private String NouvprobleFiche;
    private float noteRap;
    private float noteEnc;
  
  
    private String NouvfctFiche;
    private int version;
	
	
	 public int getIdFiche() {
		return idFiche;
	}


	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}


	public String getTitreFiche() {
		return titreFiche;
	}


	public void setTitreFiche(String titreFiche) {
		this.titreFiche = titreFiche;
	}


	public String getDescriptionFiche() {
		return descriptionFiche;
	}


	public void setDescriptionFiche(String descriptionFiche) {
		this.descriptionFiche = descriptionFiche;
	}


	public String getProbleFiche() {
		return probleFiche;
	}


	public void setProbleFiche(String probleFiche) {
		this.probleFiche = probleFiche;
	}


	public String getFctFiche() {
		return fctFiche;
	}


	public void setFctFiche(String fctFiche) {
		this.fctFiche = fctFiche;
	}


	public String getCategFiche() {
		return categFiche;
	}


	public void setCategFiche(String categFiche) {
		this.categFiche = categFiche;
	}


	public String getMotCleFiche() {
		return motCleFiche;
	}


	public void setMotCleFiche(String motCleFiche) {
		this.motCleFiche = motCleFiche;
	}


	public String getEntrepFiche() {
		return entrepFiche;
	}


	public void setEntrepFiche(String entrepFiche) {
		this.entrepFiche = entrepFiche;
	}


	public int getEtatFiche() {
		return etatFiche;
	}


	public void setEtatFiche(int etatFiche) {
		this.etatFiche = etatFiche;
	}


	public Date getAnneeFiche() {
		return anneeFiche;
	}


	public void setAnneeFiche(Date anneeFiche) {
		this.anneeFiche = anneeFiche;
	}


	public String getPaysFiche() {
		return paysFiche;
	}


	public void setPaysFiche(String paysFiche) {
		this.paysFiche = paysFiche;
	}


	public String getEcoleFiche() {
		return ecoleFiche;
	}


	public void setEcoleFiche(String ecoleFiche) {
		this.ecoleFiche = ecoleFiche;
	}


	public String getNouvprobleFiche() {
		return NouvprobleFiche;
	}


	public void setNouvprobleFiche(String nouvprobleFiche) {
		NouvprobleFiche = nouvprobleFiche;
	}


	public float getNoteRap() {
		return noteRap;
	}


	public void setNoteRap(float noteRap) {
		this.noteRap = noteRap;
	}


	public float getNoteEnc() {
		return noteEnc;
	}


	public void setNoteEnc(float noteEnc) {
		this.noteEnc = noteEnc;
	}


	public String getNouvfctFiche() {
		return NouvfctFiche;
	}


	public void setNouvfctFiche(String nouvfctFiche) {
		NouvfctFiche = nouvfctFiche;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public ChefDepartementWebService getChef() {
		return chef;
	}


	public void setChef(ChefDepartementWebService chef) {
		this.chef = chef;
	}


	@EJB
	 ChefDepartementWebService chef;
	 

}
