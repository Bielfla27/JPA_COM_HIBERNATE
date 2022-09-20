package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUltil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		Long id = 1l;
		EntityManager em = JPAUltil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		Produto p = produtoDao.buscarPorID(id);
		System.out.println(p.getPreco());
		
		List<Produto> produtos = produtoDao.buscarTodos();
		produtos.forEach(p2 -> System.out.println(p.getNome()));
		
		List<Produto> produtoPeloNome = produtoDao.buscarPorNome("Xiaomi Poco");
		produtoPeloNome.forEach(p2 -> System.out.println(p.getNome()));
		
		List<Produto> produtoPeloNomeDaCategoria = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		produtoPeloNomeDaCategoria.forEach(p2 -> System.out.println(p.getNome()));
		
	}

	private static void cadastrarProduto() {
		Categoria Celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Poco", "Bom demais", new BigDecimal("800"), Celulares );
		
		EntityManager em = JPAUltil.getEntityManager();
		ProdutoDAO produtroDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);

		
		//estou inserindo o celular na tabela mapeei na classe Produto
		em.getTransaction().begin(); //inicia a tranzação
		categoriaDao.cadastrar(Celulares);
		produtroDao.cadastrar(celular);;
		em.getTransaction().commit();
		em.close();
	}

}
