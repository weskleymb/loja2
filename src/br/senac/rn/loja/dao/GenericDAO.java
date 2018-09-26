package br.senac.rn.loja.dao;

import javax.persistence.EntityManager;

import br.senac.rn.loja.model.Produto;

public abstract class GenericDAO<T> {

	protected EntityManager manager = DataBase.getEntityManager();
	
//	abstract ? getClass();
	
	public void insert(T entity) {
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
	}
	
	public void update(T entity) {
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
	}
	
	public void delete(T entity) {
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
	}
	
//	public T findById(Integer id) {
//		return manager.find(T.class, id);
//	}
	
}
