package br.com.alura.loja.DAO;



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
}
