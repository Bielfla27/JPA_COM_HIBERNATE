package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable //serve para dizer que essa classe é embutida em uma entidade
public class DadosPessoais {
	
	private String nome;
	private String cpf;
	
	public DadosPessoais() {
		
	}
	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	} 
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
