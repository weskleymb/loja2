package br.senac.rn.loja.dao;

import javax.persistence.EntityManager;

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
				manager.persist(entity);
				break;
			case REMOVER:
				manager.remove(entity);
				break;
			case ATUALIZAR:
				manager.merge(entity);
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

}
