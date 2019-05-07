package oussama.pi.pfe.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import oussama.pi.pfe.persistence.Offre;

@Remote
public interface OffreServiceRemote {
    public void createOffre(Offre o);
    public ArrayList<Offre> afficherOffre();
    public ArrayList<Offre> affihcerMesOffre(int id);
    public void autoriser(int id);
}
