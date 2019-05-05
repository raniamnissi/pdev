package tn.esprit.tn.esprit.services;

import javax.ejb.Local;

import tn.esprit.esprit.entities.Soutenance;

@Local
public interface SoutennaceServiceLocal {
	void AddSoutanace(Soutenance soutenance);
	Soutenance AfficherSoutenance();
	void DeleteSoutenace(int Id);
	Soutenance EditSoutenance(int Id);
	

}
