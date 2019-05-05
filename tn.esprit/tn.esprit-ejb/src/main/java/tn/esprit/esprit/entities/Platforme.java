package tn.esprit.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Platforme implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private int idPlaf;
	 
	   @Column(name = "site")
	    private String site;
	   
	   @Column(name = "departement")
	    private String depP;
	   
	   @Column(name = "ecole")
	    private String ecolep;
	   
	   @Column(name = "optionp")
	    private String optionP;
	   
	   @Column(name = "classe")
	    private String classeP;
	   
	   @Column(name = "image")
	    private String imageP;
	   
	   @Temporal(TemporalType.DATE)
	    private Date anneScolaireP;

	   //empl etu fk
	
	public int getIdPlaf() {
		return idPlaf;
	}

	public void setIdPlaf(int idPlaf) {
		this.idPlaf = idPlaf;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDepP() {
		return depP;
	}

	public void setDepP(String depP) {
		this.depP = depP;
	}

	public String getEcolep() {
		return ecolep;
	}

	public void setEcolep(String ecolep) {
		this.ecolep = ecolep;
	}

	public String getOptionP() {
		return optionP;
	}

	public void setOptionP(String optionP) {
		this.optionP = optionP;
	}

	public String getClasseP() {
		return classeP;
	}

	public void setClasseP(String classeP) {
		this.classeP = classeP;
	}

	public String getImageP() {
		return imageP;
	}

	public void setImageP(String imageP) {
		this.imageP = imageP;
	}

	public Date getAnneScolaireP() {
		return anneScolaireP;
	}

	public void setAnneScolaireP(Date anneScolaireP) {
		this.anneScolaireP = anneScolaireP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Platforme(int idPlaf, String site, String depP, String ecolep, String optionP, String classeP, String imageP,
			Date anneScolaireP) {
		super();
		this.idPlaf = idPlaf;
		this.site = site;
		this.depP = depP;
		this.ecolep = ecolep;
		this.optionP = optionP;
		this.classeP = classeP;
		this.imageP = imageP;
		this.anneScolaireP = anneScolaireP;
	}
	@Override
	public String toString() {
		return "Platforme [idPlaf=" + idPlaf + ", site=" + site + ", depP=" + depP + ", ecolep=" + ecolep + ", optionP="
				+ optionP + ", classeP=" + classeP + ", imageP=" + imageP + ", anneScolaireP=" + anneScolaireP + "]";
	}


}
