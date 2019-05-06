package test;


import java.math.BigInteger;

import javax.naming.Context;
import javax.naming.InitialContext;


import javax.naming.NamingException;

import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Employe;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;
import tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote;
import tn.esprit.tn.esprit.services.FicheServiceRemote;

public class TestSansIn {

	public static void main(String[] args) throws NamingException {
		String jndiFiche="tn.esprit-ear/tn.esprit-ejb/FicheService!tn.esprit.tn.esprit.services.FicheServiceRemote";
		String jndiName="tn.esprit-ear/tn.esprit-ejb/ChefDepartementService!tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote";
		Context context;
		
		
		System.out.println("1");
			context = new InitialContext();
			System.out.println("2");

		ChefDepartementInterfaceRemote proxy=(ChefDepartementInterfaceRemote) context.lookup(jndiName);
	FicheServiceRemote proxy2=(FicheServiceRemote) context.lookup(jndiFiche);
	FichePfe fNote=new FichePfe();
	fNote.setNoteEnc(-1);
	fNote.setNoteRap(-1);
	fNote.setCategFiche("hhh");
	fNote.setEtatFiche(1);
	//proxy2.creefiche(fNote);
		System.out.println("3");

		/*for(FichePfe f:proxy.afficherFicheSanNote())
		{
			System.out.println(f.getEtatFiche());
		}
		System.out.println("4");*/
    /*  for(Employe e:proxy.employes())
      {
    	  System.out.println(e.getEcoleEmploye());
      }*/
		//System.out.println("e");
		Etudiant e=new Etudiant();
		e.setEcoleEtudiant("ooooooooooooooooohhhhhhhhh");
		e.setAutorisationEtudiant(2);
		e.setEmailEtudiant("dddd");
		e.setNomEtudiant("abcd");
		e.setCreditFinaciereEtudiant(false);
		e.setCreditPedagogiqueEtudiant(false);
		//proxy.ajouterUtilisateur2(e);
		System.out.println("************");
		Archive e1=new Archive();
		//Etudiant etudiant = proxy.getById(23);
	//	System.out.println(etudiant);
		
		System.out.println("*****nb*******");
		Long nb;
		nb=proxy.afficherNbdesEtudiantsAff(4);
		System.out.println(nb);
		System.out.println("****nb********");
		
		e1.setEtudiant(e);
		e1.setDescriptionFiche("rrr");
		for(Employe rap:proxy.affichertouslesRap())
		{
			System.out.println(rap.getEmailEmploye()+";;");
		}
		
		//proxy2.creeArchive(e1);
		//e1.setEtudiant(e.getIdEtudiant());
		//e1.setEtudiant(e);
	//proxy.ajouterUtilisateur(e1);
	/*for(Archive e2 :proxy.afficher(etudiant))
		{
			System.out.println(e2.getDescriptionFiche()+";;");
		}*/
	//***********ajout fichePfe
	FichePfe f=new FichePfe();
	f.setEtatFiche(1);
	System.out.println("************");
	//proxy2.creefiche(f);
	/*for(FichePfe f1:proxy.listerFicheAccParDirec())
	{
		System.out.println(f1.getEtatFiche());
	}*/
	Employe ens=new Employe();
	ens.setEmailEmploye("esprit");
	ens.setEcoleEmploye("aaaaaaaaaaaaa");
	//proxy.ajouterEnsei(ens);
	//Employe er=new Employe();
	//proxy=(ChefDepartementInterfaceRemote) context.lookup(jndiName);
	//er=proxy.getByIdEmploye(9);
	
	//System.out.println(proxy2.getByIdEmploye(3));
	//proxy.affecterFicheEncadrant(12,proxy.getByIdEmploye(1));
	//proxy.modifierFiches(14,"ggggggge");
	//proxy.affecterFicheEncadrant(1,ens);
	//proxy.affecterRapporteurRania(2, 4);
	System.out.println("affectation encadrant");
	proxy.affecterEncadRania(2,6);
		
	}

}
