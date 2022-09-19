package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUltil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Produto celular = new Produto("Xiaomi Poco", "Bom demais", new BigDecimal("800"), Categoria.CELULARES);
		
		EntityManager em = JPAUltil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		//estou inserindo o celular na tabela mapeei na classe Produto
		em.getTransaction().begin(); //inicia a tranzação
		dao.cadastrar(celular);;
		em.getTransaction().commit();
		em.close();
	}

}
