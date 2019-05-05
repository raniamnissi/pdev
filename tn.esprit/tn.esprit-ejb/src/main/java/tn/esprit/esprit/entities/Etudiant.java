package tn.esprit.esprit.entities;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Etudiant implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idetudiant")
    private int idEtudiant;


	@Column(name = "nom")
    private String nomEtudiant;
    
    @Column(name = "prenom")
    private String prenomEtudiant;
    
    @Column(name = "ecole")
    private String ecoleEtudiant;
    
    @Column(name = "email")
    private String emailEtudiant;
    
    @Column(name = "password")
    private String passwordEtudiant;
    
    @Column(name = "username")
    private String userNameEtudiant;
    

	@Column(name = "classe")
    private String classeEtudiant;
    
    @Column(name = "optionEtudiant")
    private String optionEtudiant;
    
    @Column(name = "creditpdagogique")
    private boolean creditPedagogiqueEtudiant;
    
    @Column(name = "creditfinaciere")
    private boolean creditFinaciereEtudiant;
    
    @Column(name = "autorisation")
    private int autorisationEtudiant;
    
    

	
	   //fiche,encadr,rapporteur fk !!!!!!!!!!!!!!!!!!!!!!
    
	//*********************************************************
 @ManyToOne
private Employe employesEnc;

public Employe getEmployesEnc() {
	return employesEnc;
}
public void setEmployesEnc(Employe employesEnc) {
	this.employesEnc = employesEnc;
}


@ManyToOne
private Employe employesRap;

public Employe getemployesRap() {
	return employesRap;
}
public void setemployesRap(Employe employesRap) {
	this.employesRap = employesRap;
}
//*****************
    /*
@OneToMany (mappedBy="etudiants")
private Employe employesRappor;

public Employe getEmployesRappor() {
	return employesRappor;
}
public void setEmployesRappor(Employe employesRappor) {
	this.employesRappor = employesRappor;
}
//**********************
/*@OneToOne
private FichePfe fiche;

public FichePfe getFiche() {
	return fiche;
}
public void setFiche(FichePfe fiche) {
	this.fiche = fiche;
}*/
//****************
@OneToOne(mappedBy="etudiant")
private Soutenance soutenance;


@OneToOne(mappedBy = "etudiant", cascade = CascadeType.REMOVE)
private FichePfe fiche;

public Soutenance getSoutenance() {
	return soutenance;
}
public void setSoutenance(Soutenance soutenance) {
	this.soutenance = soutenance;
}
//********************
public void setIdEtudiant(int idEtudiant) {
	this.idEtudiant = idEtudiant;
}


public int getIdEtudiant() {
	return idEtudiant;
}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public String getEcoleEtudiant() {
		return ecoleEtudiant;
	}

	public void setEcoleEtudiant(String ecoleEtudiant) {
		this.ecoleEtudiant = ecoleEtudiant;
	}

	public String getEmailEtudiant() {
		return emailEtudiant;
	}

	public void setEmailEtudiant(String emailEtudiant) {
		this.emailEtudiant = emailEtudiant;
	}

	public String getPasswordEtudiant() {
		return passwordEtudiant;
	}

	public void setPasswordEtudiant(String passwordEtudiant) {
		this.passwordEtudiant = passwordEtudiant;
	}

	public String getUserNameEtudiant() {
		return userNameEtudiant;
	}

	public void setUserNameEtudiant(String userNameEtudiant) {
		this.userNameEtudiant = userNameEtudiant;
	}

	public String getClasseEtudiant() {
		return classeEtudiant;
	}

	public void setClasseEtudiant(String classeEtudiant) {
		this.classeEtudiant = classeEtudiant;
	}

	public String getOptionEtudiant() {
		return optionEtudiant;
	}

	public void setOptionEtudiant(String optionEtudiant) {
		this.optionEtudiant = optionEtudiant;
	}

	public boolean isCreditPedagogiqueEtudiant() {
		return creditPedagogiqueEtudiant;
	}

	public void setCreditPedagogiqueEtudiant(boolean creditPedagogiqueEtudiant) {
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
	}

	public boolean isCreditFinaciereEtudiant() {
		return creditFinaciereEtudiant;
	}

	public void setCreditFinaciereEtudiant(boolean creditFinaciereEtudiant) {
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
	}
	

	public int getAutorisationEtudiant() {
		return autorisationEtudiant;
	}

	public void setAutorisationEtudiant(int autorisationEtudiant) {
		this.autorisationEtudiant = autorisationEtudiant;
	}

	

    
	

}
