package br.com.alura.loja.DAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder;


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
	
	public List<Produto> buscarPorParametros(String nome,
			BigDecimal preco, LocalDate dataCadastro) {
		String jpql = "SELECT p FROM Produto p WHERE 1=1";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql = " AND p.nome = :nome ";
		}
		if (preco != null) {
			jpql = " AND p.preco = :preco ";
		}
		if (dataCadastro != null) {
			jpql = " AND p.dataCadastro = :dataCadastro ";
		}
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (preco != null) {
			query.setParameter("preco", preco);
		}
		if (dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}
		
		return query.getResultList();
	}
	
	public List<Produto> buscarPorParametrosComCriteria(String nome, 
			BigDecimal preco, LocalDate dataCadastro) {
	
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtros = builder.and();
		if (nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if (preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if (dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
	}

}
