package oussama.pi.pfe.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entreprise implements Serializable{
	
	private int idEntre;
	
	private String nom;
	
	private String siteWeb;
	private String image;
	private String nomRH;
	private String prenomRH;
	private String usernameRH;
	private String passwordRH;
	private String mailRH;
	private String address;
	private int numRH;
	
	
	public Entreprise(int iD, String nom, String siteWeb,String image) {
		super();
	    this.idEntre = iD;
		this.nom = nom;
		this.siteWeb = siteWeb;
		this.image=image;
	}
	
	public Entreprise() {
		super();
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") 
	public int getIdEntre() {
		return idEntre;
	}

	public void setIdEntre(int idEntre) {
		this.idEntre = idEntre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Entreprise(String nom, String siteWeb, String image) {
		super();
		this.nom = nom;
		this.siteWeb = siteWeb;
		this.image=image;
	}

	public String getNomRH() {
		return nomRH;
	}

	public void setNomRH(String nomRH) {
		this.nomRH = nomRH;
	}

	public String getPrenomRH() {
		return prenomRH;
	}

	public void setPrenomRH(String prenomRH) {
		this.prenomRH = prenomRH;
	}

	public String getUsernameRH() {
		return usernameRH;
	}

	public void setUsernameRH(String usernameRH) {
		this.usernameRH = usernameRH;
	}

	public String getPasswordRH() {
		return passwordRH;
	}

	public void setPasswordRH(String passwordRH) {
		this.passwordRH = passwordRH;
	}

	public String getMailRH() {
		return mailRH;
	}

	public void setMailRH(String mailRH) {
		this.mailRH = mailRH;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumRH() {
		return numRH;
	}

	public void setNumRH(int numRH) {
		this.numRH = numRH;
	}

	public Entreprise(String nom, String siteWeb, String image, String nomRH, String prenomRH, String usernameRH,
			String passwordRH, String mailRH, String address, int numRH) {
		super();
		this.nom = nom;
		this.siteWeb = siteWeb;
		this.image = image;
		this.nomRH = nomRH;
		this.prenomRH = prenomRH;
		this.usernameRH = usernameRH;
		this.passwordRH = passwordRH;
		this.mailRH = mailRH;
		this.address = address;
		this.numRH = numRH;
	}

	public Entreprise(int idEntre, String nom, String siteWeb, String image, String nomRH, String prenomRH,
			String usernameRH, String passwordRH, String mailRH, String address, int numRH) {
		super();
		this.idEntre = idEntre;
		this.nom = nom;
		this.siteWeb = siteWeb;
		this.image = image;
		this.nomRH = nomRH;
		this.prenomRH = prenomRH;
		this.usernameRH = usernameRH;
		this.passwordRH = passwordRH;
		this.mailRH = mailRH;
		this.address = address;
		this.numRH = numRH;
	}
	
	
	
}
