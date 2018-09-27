package br.senac.rn.loja.testes;

import br.senac.rn.loja.dao.MarcaDAO;

public class TestaDepartamento {

	public static void main(String... args) {

//		Produto produto = new Produto();
//		produto.setNome("Camisa Generica");
//		produto.setMarca(new MarcaDAO().findById(1));
//		produto.setDepartamento(new DepartamentoDAO().findById(1));
//		
//		new ProdutoDAO().insert(produto);
//		
//		Marca m = new Marca();
//		m.setNome("Topper");
		
		System.out.println(new MarcaDAO().findByNome("top"));
		
	}

}
