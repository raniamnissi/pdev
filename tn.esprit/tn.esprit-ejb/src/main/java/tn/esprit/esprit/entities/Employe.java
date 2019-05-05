package tn.esprit.esprit.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Employe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idEmploye;
	
	   @Column(name = "nom")
	    private String nomEmploye;
	    
	    @Column(name = "prenom")
	    private String prenomEmploye;
	    
	    @Column(name = "ecole")
	    private String ecoleEmploye;
	    
	    @Column(name = "email")
	    private String emailEmploye;
	    
	    @Column(name = "password")
	    private String passwordEmploye;
	    
	    @Column(name = "userName")
	    private String userNameEmploye;
	    
	    private int employeRole;
	    private int maxEnRap;
	    private int maxEnEnca;
	    private int maxEnPreva;
	    private int maxPresid;
	    
//************
	    @OneToMany(mappedBy="employesEnc")
	    private List<FichePfe>fiches;   
	    
	    @OneToMany(mappedBy="employesRap",cascade=CascadeType.ALL)
	    private List<FichePfe>fichess;
	    
@OneToMany(mappedBy="employesEnc")
private List<Etudiant>etudiants;

public List<Etudiant> getEtudiants() {
	return etudiants;
}
public void setEtudiants(List<Etudiant> etudiants) {
	this.etudiants = etudiants;
}

@OneToMany(mappedBy="employesRap")
private List<Etudiant>etudiantss;

public List<Etudiant> getEtudiantss() {
	return etudiantss;
}
public void setEtudiantss(List<Etudiant> etudiantss) {
	this.etudiantss = etudiantss;
}

//**********
@OneToOne
private Soutenance soutenance;

public Soutenance getSoutenance() {
	return soutenance;
}


public void setSoutenance(Soutenance soutenance) {
	this.soutenance = soutenance;}

//**************

public int getIdEmploye() {
	return idEmploye;
}
		


		public int getEmployeRole() {
	return employeRole;
}
public void setEmployeRole(int employeRole) {
	this.employeRole = employeRole;
}
public Employe() {
	super();
}
public List<FichePfe> getFiches() {
	return fiches;
}
public void setFiches(List<FichePfe> fiches) {
	this.fiches = fiches;
}
public List<FichePfe> getFichess() {
	return fichess;
}
public void setFichess(List<FichePfe> fichess) {
	this.fichess = fichess;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
		public void setIdEmploye(int idEmploye) {
			this.idEmploye = idEmploye;
		}


		public String getNomEmploye() {
			return nomEmploye;
		}


		public void setNomEmploye(String nomEmploye) {
			this.nomEmploye = nomEmploye;
		}


		public String getPrenomEmploye() {
			return prenomEmploye;
		}


		public void setPrenomEmploye(String prenomEmploye) {
			this.prenomEmploye = prenomEmploye;
		}


		public String getEcoleEmploye() {
			return ecoleEmploye;
		}


		public void setEcoleEmploye(String ecoleEmploye) {
			this.ecoleEmploye = ecoleEmploye;
		}


		public String getEmailEmploye() {
			return emailEmploye;
		}


		public void setEmailEmploye(String emailEmploye) {
			this.emailEmploye = emailEmploye;
		}


		public String getPasswordEmploye() {
			return passwordEmploye;
		}


		public void setPasswordEmploye(String passwordEmploye) {
			this.passwordEmploye = passwordEmploye;
		}


		public String getUserNameEmploye() {
			return userNameEmploye;
		}


		public void setUserNameEmploye(String userNameEmploye) {
			this.userNameEmploye = userNameEmploye;
		}
		public int getMaxEnRap() {
			return maxEnRap;
		}
		public void setMaxEnRap(int maxEnRap) {
			this.maxEnRap = maxEnRap;
		}
		public int getMaxEnEnca() {
			return maxEnEnca;
		}
		public void setMaxEnEnca(int maxEnEnca) {
			this.maxEnEnca = maxEnEnca;
		}
		public int getMaxEnPreva() {
			return maxEnPreva;
		}
		public void setMaxEnPreva(int maxEnPreva) {
			this.maxEnPreva = maxEnPreva;
		}
		public int getMaxPresid() {
			return maxPresid;
		}
		public void setMaxPresid(int maxPresid) {
			this.maxPresid = maxPresid;
		}
	


		


	
	    
	   
	    //*************** relations fiche w soutn !!!
	     
	
	 
	 	
	    
	    
}
