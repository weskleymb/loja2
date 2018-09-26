package br.senac.rn.loja.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import br.senac.rn.loja.model.Produto;

public class ProdutoDAO extends GenericDAO<Produto> {

	@Override
	public Class<Produto> getClassType() {
		return Produto.class;
	}
			
	public List<Produto> findAll() {
		String sql = "SELECT p FROM Produto p";
		TypedQuery<Produto> query = manager
				.createQuery(sql, Produto.class);
		return query.getResultList();
	}
	
}
