package tn.esprit.tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.tn.esprit.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
