package br.senac.rn.loja.testes;

import br.senac.rn.loja.dao.MarcaDAO;
import br.senac.rn.loja.model.Marca;

public class TestaDepartamento {

	public static void main(String[] args) {

//		Produto produto = new Produto();
//		produto.setNome("Camisa Generica");
//		produto.setMarca(new MarcaDAO().findById(1));
//		produto.setDepartamento(new DepartamentoDAO().findById(1));
//		
//		new ProdutoDAO().insert(produto);
		
		Marca m = new Marca();
		m.setNome("Topper");
		
		new MarcaDAO().insert(m);
		
	}

}
