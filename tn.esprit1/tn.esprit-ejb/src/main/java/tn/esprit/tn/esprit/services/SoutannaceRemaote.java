package tn.esprit.tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.esprit.entities.Soutenance;

@Remote
public interface SoutannaceRemaote {
	void AddSoutanace(Soutenance soutenance);
	Soutenance AfficherSoutenance();
	void DeleteSoutenace(int Id);
	Soutenance EditSoutenance(int Id);
	

}
