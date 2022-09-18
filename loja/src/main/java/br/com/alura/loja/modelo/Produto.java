package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "produtos") //ensinando a JPA qual nome certo da tabelo
public class Produto {
	
	@Id //dizendo a JPA que o primeiro � a chave prim�ria 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //dizendo a JPA que quem vai dar algum valor para esse n�mero � o banco de dados e qual a estrategia que ele vai usar para salvar
	private Long id;
	private String nome;
	//@Column (name = "desc") ensinando a JPA que o nome certo do atributo na tabela
	private String descricao;
	private BigDecimal preco;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	

}
