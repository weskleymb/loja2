package br.senac.rn.loja.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.senac.rn.loja.dao.DepartamentoDAO;
import br.senac.rn.loja.model.Departamento;

public class TestaDepartamento {

	public static void main(String[] args) {

		Departamento departamento = new Departamento();
		departamento.setNome("Eletrodomesticos");
		departamento.setSigla("ELD");
		departamento.setDesconto(0.07f);
		departamento.setFone("8432321415");
		
		DepartamentoDAO dao = new DepartamentoDAO();
		dao.insert(departamento);
		
		System.out.println(dao.findAll());
		
	}

}
