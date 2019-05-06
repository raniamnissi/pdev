package oussama.pi.pfe.presentation.mbeans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import oussama.pi.pfe.persistence.Entreprise;
import oussama.pi.pfe.services.EntrepriseService;
import oussama.pi.pfe.services.EntrepriseServiceRemote;

@ManagedBean
@SessionScoped
public class EntrepriseBean{
	private Part part;
	private String image;
	private String nom;
	private String siteWeb;
	private String nomRH;
	private String prenomRH;
	private String mailRH;
	private int numRH;
	private String usernameRH;
	private String passwordRH;
	private String address;
	private ArrayList<Entreprise> entres;
	@EJB
	EntrepriseService Es;
	
	public EntrepriseBean() {
		super();
	}

	public void ajoutEntreprise() throws IOException{
		part.write("E:\\JEE\\workspace\\pfe\\pfe-web\\src\\main\\webapp\\ressources\\images\\"+getFileName(part));
		this.image=	getFileName(this.part);
		Es.addEntreprise(new Entreprise(nom,siteWeb,image,nomRH,prenomRH,usernameRH,passwordRH,mailRH,address,numRH));
	}
	public ArrayList<Entreprise> getEntres(){
		 entres=(ArrayList<Entreprise>) Es.getAll();
		 return entres;
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



	
	
	
	public String Upload() throws IOException {
		part.write("E:\\JEE\\workspace\\pfe\\pfe-web\\src\\main\\webapp\\ressources\\images\\"+getFileName(part));
		return "result";
	}
	private static String getFileName(Part part){
		
		for(String cd: part.getHeader("content-disposition").split(";")){
			
			if(cd.trim().startsWith("filename")){
				
				String filename= cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
			}
			
		}
		return null;
		
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getMailRH() {
		return mailRH;
	}

	public void setMailRH(String mailRH) {
		this.mailRH = mailRH;
	}

	public int getNumRH() {
		return numRH;
	}

	public void setNumRH(int numRH) {
		this.numRH = numRH;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
 
 

  
	
}
