package br.senac.rn.loja.dao;

import br.senac.rn.loja.model.Departamento;

public class DepartamentoDAO extends GenericDAO<Departamento> {

	@Override
	public Class<Departamento> getClassType() {
		return Departamento.class;
	}

}
