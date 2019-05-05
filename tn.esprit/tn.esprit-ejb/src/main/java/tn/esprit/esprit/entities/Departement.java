package tn.esprit.esprit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
private int id;
	
	 
	@Column(name = "ecole")	 
private String ecole;
	@Column(name = "optionetudiant")
private String option;

public Departement(int id, String ecole, String option) {
		super();
		this.id = id;
		this.ecole = ecole;
		this.option = option;
	}

public static long getSerialversionuid() {
		return serialVersionUID;
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEcole() {
	return ecole;
}
public void setEcole(String ecole) {
	this.ecole = ecole;
}
public String getOption() {
	return option;
}
public void setOption(String option) {
	this.option = option;
}
@Override
public String toString() {
	return "Departement [id=" + id + ", ecole=" + ecole + ", option=" + option + "]";
}

}
