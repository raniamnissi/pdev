package tn.esprit.test.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.test.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
