package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
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
	@Embedded //dizendo pra jpa pegar da classe que é embutida
	private DadosPessoais dadosPessoais;

	public Cliente(){
		
	}
		
	public Cliente( String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	public String getNome(){
		return dadosPessoais.getNome();
	}

	public String getCpf(){
		return dadosPessoais.getCpf();
	}
}
