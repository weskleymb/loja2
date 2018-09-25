package br.senac.rn.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.senac.rn.loja.model.Departamento;

public class DepartamentoDAO {

	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public DepartamentoDAO() {
		this.factory = Persistence.createEntityManagerFactory("ConexaoDB");
		this.manager = factory.createEntityManager();
	}
	
	public void insert(Departamento departamento) {
		manager.getTransaction().begin();
		manager.persist(departamento);
		manager.getTransaction().commit();
	}
	
	public void update(Departamento departamento) {
		manager.getTransaction().begin();
		manager.merge(departamento);
		manager.getTransaction().commit();
	}
	
	public void delete(Departamento departamento) {
		manager.getTransaction().begin();
		manager.remove(departamento);
		manager.getTransaction().commit();
	}
	
	public Departamento findById(Integer id) {
		return manager.find(Departamento.class, id);
	}
	
	public List<Departamento> findAll() {
		String sql = "SELECT d FROM Departamento d";
		TypedQuery<Departamento> query = manager
				.createQuery(sql, Departamento.class);
		return query.getResultList();
	}
	
	public void close() {
		manager.close();
		factory.close();
	}
	
}
