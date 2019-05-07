package oussama.pi.pfe.persistence;


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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Employe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    private int idEmploye;
	
	   
	    private String nomEmploye;
	    
	    
	    private String prenomEmploye;
	    
	   
	    private String ecoleEmploye;
	    
	    
	    private String emailEmploye;
	    
	   
	    private String passwordEmploye;
	    
	   
	    private String userNameEmploye;
	    private int nbmax;
	    private String favorie;
	    
	    
	   
	    private String employeRole;
	  
	    
//************

//**************
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")    
public int getIdEmploye() {
	return idEmploye;
}
		
private List<FichePfe> fichesEnca;


@OneToMany(mappedBy="encadrant")
public List<FichePfe> getFichesEnca() {
	return fichesEnca;
}
public void setFichesEnca(List<FichePfe> fichesEnca) {
	this.fichesEnca = fichesEnca;
}

private List<FichePfe> fichesRap;

@OneToMany(mappedBy="rapporteur")
public List<FichePfe> getFichesRap() {
	return fichesRap;
}
public void setFichesRap(List<FichePfe> fichesRap) {
	this.fichesRap = fichesRap;
}

private List<FichePfe> fichesPre;

@OneToMany(mappedBy="prevalid")
public List<FichePfe> getFichesPre() {
	return fichesPre;
}
public void setFichesPre(List<FichePfe> fichesPre) {
	this.fichesPre = fichesPre;
}
		public Employe() {
	super();
}
		public Employe(int idEmploye, String nomEmploye, String prenomEmploye, String ecoleEmploye, String emailEmploye,
				String passwordEmploye, String userNameEmploye,String employeRole) {
			super();
			this.idEmploye = idEmploye;
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.ecoleEmploye = ecoleEmploye;
			this.emailEmploye = emailEmploye;
			this.passwordEmploye = passwordEmploye;
			this.userNameEmploye = userNameEmploye;
			this.employeRole = employeRole;
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

		 
		public String getEmployeRole() {
			return employeRole;
		}


		public void setEmployeRole(String employeRole) {
			this.employeRole = employeRole;
		}
		
		@Override
		public String toString() {
			return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
					+ ", ecoleEmploye=" + ecoleEmploye + ", emailEmploye=" + emailEmploye + ", passwordEmploye="
					+ passwordEmploye + ", userNameEmploye=" + userNameEmploye + ", employeRole=" + employeRole + "]";
		}
		public int getNbmax() {
			return nbmax;
		}
		public void setNbmax(int nbmax) {
			this.nbmax = nbmax;
		}
		public String getFavorie() {
			return favorie;
		}
		public void setFavorie(String favorie) {
			this.favorie = favorie;
		}



		



	
	    
	   
	    //*************** relations fiche w soutn !!!
	     
	
	 
	 	
	    
	    
}
