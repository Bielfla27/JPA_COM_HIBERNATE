package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Poco");
		celular.setDescricao("Bom demais");
		celular.setPreco(new BigDecimal("800"));
		
		//criando um objeto do tipo EntiyManager
		//O par�metro passadoo no factory � o  name do persistence-unit que esta no persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager em = factory.createEntityManager();
		//estou inserindo o celular na tabela mapeei na classe Produto
		em.getTransaction().begin(); //inicia a tranza��o
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}

}
