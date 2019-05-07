package oussama.pi.pfe.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import oussama.pi.pfe.persistence.Categorie;

@Remote
public interface CatServiceRemote {
	public ArrayList reupCat();
	public void ajoutCat(Categorie c);
}
