package oussama.pi.pfe.persistence;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Etudiant implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    private int idEtudiant;
    
    
    private String nomEtudiant;
    
   
    private String prenomEtudiant;
    
    
    private String ecoleEtudiant;
    
    
    private String emailEtudiant;
    
    
    private String passwordEtudiant;
    
    
    private String userNameEtudiant;
    
   
    private String classeEtudiant;
    
    
    private String optionEtudiant;
    
    
    private boolean creditPedagogiqueEtudiant;
    
    
    private boolean creditFinaciereEtudiant;
    
    
    private int autorisationEtudiant;
    
    private int annulation;
    private String msg;
    
    

	
	   //fiche,encadr,rapporteur fk !!!!!!!!!!!!!!!!!!!!!!
    
	//*********************************************************


//**********************
private FichePfe fiche;
@OneToOne(mappedBy = "etudiant", cascade = CascadeType.REMOVE)
public FichePfe getFiche() {
	return fiche;
}
public void setFiche(FichePfe fiche) {
	this.fiche = fiche;
}
//****************
private Convention con;
@OneToOne(mappedBy = "etudiant", cascade = CascadeType.REMOVE)
public Convention getCon() {
	return con;
}
public void setCon(Convention con) {
	this.con =con;
}
//********************

public void setIdEtudiant(int idEtudiant) {
	this.idEtudiant = idEtudiant;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
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

	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String ecoleEtudiant,
			String emailEtudiant, String passwordEtudiant, String userNameEtudiant, String classeEtudiant,
			String optionEtudiant, boolean creditPedagogiqueEtudiant, boolean creditFinaciereEtudiant) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.passwordEtudiant = passwordEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.classeEtudiant = classeEtudiant;
		this.optionEtudiant = optionEtudiant;
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant="
				+ prenomEtudiant + ", ecoleEtudiant=" + ecoleEtudiant + ", emailEtudiant=" + emailEtudiant
				+ ", passwordEtudiant=" + passwordEtudiant + ", userNameEtudiant=" + userNameEtudiant
				+ ", classeEtudiant=" + classeEtudiant + ", optionEtudiant=" + optionEtudiant
				+ ", creditPedagogiqueEtudiant=" + creditPedagogiqueEtudiant + ", creditFinaciereEtudiant="
				+ creditFinaciereEtudiant + "]";
	}
	public Etudiant() {
		super();
	}
	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String ecoleEtudiant,
			String emailEtudiant, String passwordEtudiant, String userNameEtudiant, String classeEtudiant,
			String optionEtudiant, boolean creditPedagogiqueEtudiant, boolean creditFinaciereEtudiant,
			int autorisationEtudiant, Employe employesEnc, Employe employesRappor) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.passwordEtudiant = passwordEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.classeEtudiant = classeEtudiant;
		this.optionEtudiant = optionEtudiant;
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
		this.autorisationEtudiant = autorisationEtudiant;
		
		
	}
	public int getAnnulation() {
		return annulation;
	}
	public void setAnnulation(int annulation) {
		this.annulation = annulation;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


    
    
	

}
