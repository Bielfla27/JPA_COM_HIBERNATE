package br.com.alura.loja.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDAO {
	
	private EntityManager em;
	
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public Produto buscarPorID(Long id) {
		return em.find(Produto.class, id); //Coloco o nome da entidade e o id que quero buscar
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p"; //lembrar que aqui ele passa o nome que est� na entidade n�o na tabela
		return em.createQuery(jpql,Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p Where p.nome = :nome"; //lembrar que aqui ele passa o nome que est� na entidade n�o na tabela
		return em.createQuery(jpql,Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}

	public List<Produto> buscarPorNomeDaCategoria(String nome){
		return em.createNamedQuery("Produto.buscarPorNomeDaCategoria",Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p Where p.nome = :nome"; //lembrar que aqui ele passa o nome que est� na entidade n�o na tabela
		return em.createQuery(jpql,BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult(); //Com o m�todo SingleResult trago apenasa um resultado de consulta
	}

}
