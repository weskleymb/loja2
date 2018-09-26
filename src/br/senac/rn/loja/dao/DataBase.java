package br.senac.rn.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBase {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
	public static EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("ConexaoDB");
		manager = factory.createEntityManager();
		return manager;
	}
	
}
