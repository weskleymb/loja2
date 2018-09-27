package br.senac.rn.loja.dao;

import br.senac.rn.loja.model.Venda;

public class VendaDAO extends GenericDAO<Venda> {

	@Override
	public Class<Venda> getClassType() {
		return Venda.class;
	}

}
