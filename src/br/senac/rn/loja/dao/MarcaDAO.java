package br.senac.rn.loja.dao;

import br.senac.rn.loja.model.Marca;

public class MarcaDAO extends GenericDAO<Marca> {

	@Override
	public Class<Marca> getClassType() {
		return Marca.class;
	}
	
}
