package br.senac.rn.loja.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.senac.rn.loja.model.Produto;

public class ProdutoDAO extends GenericDAO<Produto> {

	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public ProdutoDAO() {
		this.factory = Persistence.createEntityManagerFactory("ConexaoDB");
		this.manager = factory.createEntityManager();
	}
	
	public Produto findById(Integer id) {
		return manager.find(Produto.class, id);
	}
	
	public List<Produto> findAll() {
		String sql = "SELECT p FROM Produto p";
		TypedQuery<Produto> query = manager
				.createQuery(sql, Produto.class);
		return query.getResultList();
	}
	
	public void close() {
		manager.close();
		factory.close();
	}
	
}
