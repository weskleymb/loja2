package br.senac.rn.loja.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.senac.rn.loja.model.Marca;

public class MarcaDAO extends GenericDAO<Marca> {

	@Override
	public Class<Marca> getClassType() {
		return Marca.class;
	}
	
	public List<Marca> findAll() {
		String sql = "SELECT m FROM Marca m";
		TypedQuery<Marca> query = super.getEntityManager().createQuery(sql, Marca.class);
		return query.getResultList();
	}

}
