package br.senac.rn.loja.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.senac.rn.loja.model.Marca;

public class MarcaDAO {

	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public MarcaDAO() {
		this.factory = Persistence.createEntityManagerFactory("ConexaoDB");
		this.manager = factory.createEntityManager();
	}
	
	public void insert(Marca marca) {
		manager.getTransaction().begin();
		manager.persist(marca);
		manager.getTransaction().commit();
	}
	
	public void update(Marca marca) {
		manager.getTransaction().begin();
		manager.merge(marca);
		manager.getTransaction().commit();
	}
	
	public void delete(Marca marca) {
		manager.getTransaction().begin();
		manager.remove(marca);
		manager.getTransaction().commit();
	}
	
	public Marca findById(Integer id) {
		return manager.find(Marca.class, id);
	}
	
	public List<Marca> findAll() {
		String sql = "SELECT m FROM Marca m";
		TypedQuery<Marca> query = manager
				.createQuery(sql, Marca.class);
		return query.getResultList();
	}
	
	public void close() {
		manager.close();
		factory.close();
	}
	
}
