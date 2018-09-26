package br.senac.rn.loja.dao;

import javax.persistence.EntityManager;

public abstract class GenericDAO<T> {

	protected EntityManager manager = DataBase.getEntityManager();

	public abstract Class<T> getClassType();

	private void operacaoDataBase(Operacao operacao, T entity) {
		manager.getTransaction().begin();
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
		manager.getTransaction().commit();
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
		return manager.find(this.getClassType(), id);
	}

}
