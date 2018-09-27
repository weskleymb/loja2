package br.senac.rn.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBase {

	private static DataBase instance = new DataBase();
    private static EntityManager manager;

    private DataBase() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ConexaoDB");
        manager = factory.createEntityManager();
    }

    public static DataBase getInstance() {
        return instance;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

}
