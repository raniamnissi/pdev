package oussama.pi.pfe.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offre implements Serializable{

	private int id;
	private String nomEntre;
	private String annonce;
	private String image;
	private int idEntre;
	private int auto;
	private String mail;
	public Offre() {
		super();
	}
	public Offre(int id, String nomEntre, String annonce, String image,int idEntre,int auto) {
		super();
		this.id = id;
		this.nomEntre = nomEntre;
		this.annonce = annonce;
		this.image = image;
		this.idEntre=idEntre;
		this.auto=auto;
	}
	public Offre(String nomEntre, String annonce, String image,int idEntre,int auto, String mail) {
		super();
		this.nomEntre = nomEntre;
		this.annonce = annonce;
		this.image = image;
		this.idEntre=idEntre;
		this.auto=auto;
		this.mail=mail;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomEntre() {
		return nomEntre;
	}
	public void setNomEntre(String nomEntre) {
		this.nomEntre = nomEntre;
	}
	public String getAnnonce() {
		return annonce;
	}
	public void setAnnonce(String annonce) {
		this.annonce = annonce;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getIdEntre() {
		return idEntre;
	}
	public void setIdEntre(int idEntre) {
		this.idEntre = idEntre;
	}
	public int getAuto() {
		return auto;
	}
	public void setAuto(int auto) {
		this.auto = auto;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
