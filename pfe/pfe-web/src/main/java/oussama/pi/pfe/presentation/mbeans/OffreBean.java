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

@ManagedBean
@SessionScoped
public class OffreBean {

	private String nomEntre;
	private String annonce;
	private String image;
	private Part part;
	private int idEntre;
	private ArrayList<Offre> offres;
	private ArrayList<Offre> myoffers;
	public Entreprise e=new Entreprise(20,"vermeg","siteWeb","aaa","","","","","","",0);
	@EJB
	OffreService os;
	
	public void addOffre() throws IOException{
		part.write("E:\\JEE\\workspace\\pfe\\pfe-web\\src\\main\\webapp\\ressources\\images\\"+getFileName(part));
		this.image=	getFileName(this.part);
		os.createOffre(new Offre(e.getNom(),annonce,image,e.getIdEntre(),0));
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
		myoffers=os.affihcerMesOffre(e.getIdEntre());
		return myoffers;
	}

	public void setMyoffers(ArrayList<Offre> myOffers) {
		this.myoffers = myOffers;
	}
	
}
