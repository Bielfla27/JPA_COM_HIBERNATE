package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "categorias")
public class Categoria {
	
	@Id //dizendo a JPA que o primeiro é a chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //dizendo a JPA que quem vai dar algum valor para esse número é o banco de dados e qual a estrategia que ele vai usar para salvar
	private Long id;
	private String nome;
	
	public Categoria() {
		
	}

	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
