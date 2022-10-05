package br.com.alura.loja.DAO;



import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;

public class PedidoDAO {
	
	private EntityManager em;
	
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido Pedido) {
		this.em.persist(Pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	
	public List<Object[]> relatorioDeVendas(){
		String jpql = "SELECT produto.nome, SUM(item.quantidade), MAX(pedido.dataPedido) "
				+ "FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto "
				+ "GROUP BY produto.nome ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, Object[].class).getResultList(); //o resultList me devolve uma lista de resultados
	}
	
	
	
	
	
	
}
