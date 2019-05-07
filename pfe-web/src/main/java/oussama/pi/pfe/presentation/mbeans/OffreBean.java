package oussama.pi.pfe.presentation.mbeans;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import oussama.pi.pfe.persistence.Entreprise;
import oussama.pi.pfe.persistence.Offre;
import oussama.pi.pfe.services.OffreService;
import oussama.pi.pfe.presentation.mbeans.LoginBean;

@ManagedBean
@SessionScoped
public class OffreBean {

	private String nomEntre;
	private String annonce;
	private String image;
	private Part part;
	private int idEntre;
	private String mail;
	private ArrayList<Offre> offres;
	private ArrayList<Offre> myoffers;
	private ArrayList<Offre> nonOffers;
	public Entreprise e=new Entreprise(20,"vermeg","siteWeb","aaa","","","","","oussama.benali.3@esprit.tn","",0);
	@EJB
	OffreService os;
	
	public void addOffre() throws IOException{
		part.write("E:\\JEE\\workspace\\pfe\\pfe-web\\src\\main\\webapp\\ressources\\images\\"+getFileName(part));
		this.image=	getFileName(this.part);
		os.createOffre(new Offre(oussama.pi.pfe.presentation.mbeans.LoginBean2.E1.getNom(),annonce,image,oussama.pi.pfe.presentation.mbeans.LoginBean2.E1.getIdEntre(),0,oussama.pi.pfe.presentation.mbeans.LoginBean2.E1.getMailRH()));
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

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public int getIdEntre() {
		return idEntre;
	}

	public void setIdEntre(int idEntre) {
		this.idEntre = idEntre;
	}

	public Entreprise getE() {
		return e;
	}

	public void setE(Entreprise e) {
		this.e = e;
	}

	public OffreBean() {
		super();
	}

	public ArrayList<Offre> getOffres() {
		offres=os.afficherOffre();
		return offres;
	}

	public void setOffres(ArrayList<Offre> offres) {
		this.offres = offres;
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

	public ArrayList<Offre> getMyoffers() {
		myoffers=os.affihcerMesOffre(oussama.pi.pfe.presentation.mbeans.LoginBean2.E1.getIdEntre());
		return myoffers;
	}

	public void setMyoffers(ArrayList<Offre> myOffers) {
		this.myoffers = myOffers;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public void SendMail(String mail,String nom){
		SendingMail sn=new SendingMail("Hello Sir; \n I want to have an internship in your percious Company "+nom+". \n Thank you!",mail, "End Of Study Project internship");
		sn.envoyer();
	}
	public void auto(int id){
		os.autoriser(id);
	}

	public ArrayList<Offre> getNonOffers() {
		nonOffers=os.afficherOffreNon();
		return nonOffers;
	}

	public void setNonOffers(ArrayList<Offre> nonOffers) {
		this.nonOffers = nonOffers;
	}
	
	
}
