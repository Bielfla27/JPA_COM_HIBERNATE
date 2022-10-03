package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "pedidos") //ensinando a JPA qual nome certo da tabelo
public class Pedido {
	

	@Id //dizendo a JPA que o primeiro � a chave prim�ria 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //dizendo a JPA que quem vai dar algum valor para esse n�mero � o banco de dados e qual a estrategia que ele vai usar para salvar
	private Long id;
	private LocalDate dataPedido = LocalDate.now();
	private BigDecimal valorTotal;
	@ManyToOne
	private Cliente cliente;
						  //atributo
	@OneToMany(mappedBy = "pedido") //falando pra jpa que já existe esse relacionamento na outra classe atráves do atribudo pedido
	private List<ItemPedido> itens = new ArrayList<>(); //sempre iniciar a lista por boa pratica
	
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
	
	void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
	}
    
	
    
}
