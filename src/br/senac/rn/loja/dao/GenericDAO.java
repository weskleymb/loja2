package br.senac.rn.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericDAO<T> {

	private static EntityManager manager;

	public abstract Class<T> getClassType();

	protected EntityManager getEntityManager() {
		if (manager == null || !manager.isOpen()) {
			manager = DataBase.getInstance().getEntityManager();
		}
		return manager;
	}

	private void operacaoDataBase(Operacao operacao, T entity) {
		this.getEntityManager().getTransaction().begin();
		switch (operacao) {
			case INSERIR:
				this.getEntityManager().persist(entity);
				break;
			case REMOVER:
				this.getEntityManager().remove(entity);
				break;
			case ATUALIZAR:
				this.getEntityManager().merge(entity);
		}
		this.getEntityManager().getTransaction().commit();
	}
	
	public void insert(T entity) {
		operacaoDataBase(Operacao.INSERIR, entity);
	}

	public void update(T entity) {
		operacaoDataBase(Operacao.ATUALIZAR, entity);
	}

	public void delete(T entity) {
		operacaoDataBase(Operacao.REMOVER, entity);
	}

	public T findById(Integer id) {
		return this.getEntityManager().find(this.getClassType(), id);
	}
	
	public List<T> findAll() {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(this.getClassType());
		Root<T> entity = query.from(this.getClassType());
		CriteriaQuery<T> select = query.select(entity);
		TypedQuery<T> consulta = this.getEntityManager().createQuery(select);
		return consulta.getResultList();
	}
	
	public List<T> findAll2() {
		String entity = this.getClassType().getName();
		String sql = "SELECT t FROM " + entity + " t";
		TypedQuery<T> query = this.getEntityManager()
				.createQuery(sql, this.getClassType());
		return query.getResultList();
	}

}
