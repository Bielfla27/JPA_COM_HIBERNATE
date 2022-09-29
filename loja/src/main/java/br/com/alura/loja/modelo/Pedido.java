package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "pedidos") //ensinando a JPA qual nome certo da tabelo
public class Pedido {
	

	@Id //dizendo a JPA que o primeiro é a chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //dizendo a JPA que quem vai dar algum valor para esse número é o banco de dados e qual a estrategia que ele vai usar para salvar
	private Long id;
	private LocalDate dataPedido = LocalDate.now();
	private BigDecimal valorTotal;
	@ManyToOne
	private Cliente cliente;
	
    public Pedido() {

    }

	public Pedido(LocalDate dataPedido, BigDecimal valorTotal, Cliente cliente) {
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
	
    
}
