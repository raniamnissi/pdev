package oussama.pi.pfe.services;

import javax.ejb.Remote;

import oussama.pi.pfe.persistence.Archive;

@Remote
public interface ArchiveServiceRemote {
	public void creeArchive(Archive ar);

}
