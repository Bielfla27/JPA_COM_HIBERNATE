package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUltil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Categoria Celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Poco", "Bom demais", new BigDecimal("800"), Celulares );
		
		EntityManager em = JPAUltil.getEntityManager();
		ProdutoDAO produtroDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);

		
		//estou inserindo o celular na tabela mapeei na classe Produto
		em.getTransaction().begin(); //inicia a tranza��o
		categoriaDao.cadastrar(Celulares);
		produtroDao.cadastrar(celular);;
		em.getTransaction().commit();
		em.close();
	}

}