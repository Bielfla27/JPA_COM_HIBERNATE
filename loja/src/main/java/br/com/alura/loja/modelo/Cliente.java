package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "clientes") //ensinando a JPA qual nome certo da tabelo
public class Cliente {
	
	@Id //dizendo a JPA que o primeiro � a chave prim�ria 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //dizendo a JPA que quem vai dar algum valor para esse n�mero � o banco de dados e qual a estrategia que ele vai usar para salvar
	private Long id;
	private String nome;
	private String cpf;
	
	public Cliente(){
		
	}
		
	
	public Cliente( String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
