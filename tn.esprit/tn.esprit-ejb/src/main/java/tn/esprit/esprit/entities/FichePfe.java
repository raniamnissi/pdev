
package tn.esprit.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FichePfe implements Serializable {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	    private int idFiche;
	  
	  @Column(name = "titre")
	    private String titreFiche;
	  
	  @Column(name = "Description")
	    private String descriptionFiche;
	    
	  @Column(name = "problematique")
	    private String probleFiche;
	  
	  @Column(name = "fonction")
	    private String fctFiche;
	  
	  @Column(name = "categorie")
	    private String categFiche;
	  
	  @Column(name = "motCle")
	    private String motCleFiche;
	  
	  @Column(name = "entreprise")
	    private String entrepFiche;
	  
	  @Column(name = "etat")
	    private int etatFiche;
	  
	
	  
	  @Temporal(TemporalType.DATE)
	    private Date anneeFiche;
	  
	  @Column(name = "pays")
	    private String paysFiche;
	  
	  @Column(name = "ecole")
	    private String ecoleFiche;
	  

	    private String NouvprobleFiche;
	    private float noteRap;
	    private float noteEnc;
	  
	  
	    private String NouvfctFiche;
	    private int version;
//etu fk

	  //*******************
	    @ManyToOne
	    private Employe employesEnc;
	    @ManyToOne(cascade = {CascadeType.ALL})
	    private Employe employesRap;
	  @OneToOne
	  private Etudiant etudiant;

	  public Etudiant getEtudiant() {
			return etudiant;
		}

		public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
		}
	  
	  //***********
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Employe getEmployesEnc() {
		return employesEnc;
	}

	public void setEmployesEnc(Employe employesEnc) {
		this.employesEnc = employesEnc;
	}

	public Employe getEmployesRap() {
		return employesRap;
	}

	public void setEmployesRap(Employe employesRap) {
		this.employesRap = employesRap;
	}

	@Override
	public String toString() {
		return "FichePfe [idFiche=" + idFiche + ", titreFiche=" + titreFiche + ", descriptionFiche=" + descriptionFiche
				+ ", probleFiche=" + probleFiche + ", fctFiche=" + fctFiche + ", categFiche=" + categFiche
				+ ", motCleFiche=" + motCleFiche + ", entrepFiche=" + entrepFiche + ", etatFiche=" + etatFiche
				+ ", anneeFiche=" + anneeFiche + ", paysFiche=" + paysFiche + ", ecoleFiche=" + ecoleFiche
				+ ", NouvprobleFiche=" + NouvprobleFiche + ", NouvfctFiche=" + NouvfctFiche + ", version=" + version
				+ ", employesEnc=" + employesEnc + ", employesRap=" + employesRap + ", etudiant=" + etudiant + "]";
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
	  
	  

}
