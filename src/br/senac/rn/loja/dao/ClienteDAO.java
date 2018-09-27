package br.senac.rn.loja.dao;

import br.senac.rn.loja.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

	@Override
	public Class<Cliente> getClassType() {
		return Cliente.class;
	}

}
