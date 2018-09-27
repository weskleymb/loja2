package br.senac.rn.loja.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import br.senac.rn.loja.model.Departamento;

public class DepartamentoDAO extends GenericDAO<Departamento> {

	@Override
	public Class<Departamento> getClassType() {
		return Departamento.class;
	}
		
	public List<Departamento> findAll() {
		String sql = "SELECT d FROM Departamento d";
		TypedQuery<Departamento> query = super.getEntityManager().createQuery(sql, Departamento.class);
		return query.getResultList();
	}
	
}
