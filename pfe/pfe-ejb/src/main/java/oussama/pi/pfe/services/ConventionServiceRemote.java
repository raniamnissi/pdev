package oussama.pi.pfe.services;

import javax.ejb.Remote;

import oussama.pi.pfe.persistence.Convention;

@Remote
public interface ConventionServiceRemote {

	public void ajoutConvnetion(Convention c);
	public Convention get(int id);
}
