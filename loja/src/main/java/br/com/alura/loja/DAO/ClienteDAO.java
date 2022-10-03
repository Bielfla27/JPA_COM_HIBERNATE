package br.com.alura.loja.DAO;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;

public class ClienteDAO {
	
	private EntityManager em;
	
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public Cliente buscarPorID(Long id) {
		return em.find(Cliente.class, id); //Coloco o nome da entidade e o id que quero buscar
	}
	
}
