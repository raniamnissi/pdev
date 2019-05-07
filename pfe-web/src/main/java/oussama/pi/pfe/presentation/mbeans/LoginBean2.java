package oussama.pi.pfe.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import oussama.pi.pfe.persistence.Entreprise;
import oussama.pi.pfe.persistence.Etudiant;
import oussama.pi.pfe.services.EntrepriseService;
import oussama.pi.pfe.services.EtudiantService;

@ManagedBean
@SessionScoped
public class LoginBean2 {
private String username;
private String password;
static Etudiant e;
static Entreprise E1;

@EJB
EntrepriseService es;

@EJB
EtudiantService etus;

public LoginBean2() {
	super();
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String Login(){
	E1=null;
	e=null;
	String ee=null;
	
	

	if(es.getEntre(username, password)!=null){
		E1=es.getEntre(username, password);
		ee="/template/AddOffre?faces-redirect=true";
	}
	
	if(username.equals("admin") && (password.equals("admin"))){
		ee="/template/AddEntre?faces-redirect=true";
	}
	return ee;
}

public Etudiant getE() {
	return e;
}

public void setE(Etudiant e) {
	this.e = e;
}

public Entreprise getE1() {
	return E1;
}

public void setE1(Entreprise e1) {
	E1 = e1;
}


public String logout(){
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	E1=null;
	e=null;
	System.out.println(E1.getAddress()+e.getClasseEtudiant());
	return "/template/Login?faces-redirect=true";
}



}
