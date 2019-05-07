package oussama.pi.pfe.services;

import java.util.List;

import javax.ejb.Local;

import oussama.pi.pfe.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
