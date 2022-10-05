package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column (name = "valor_total")//column + name = para dizer como quero que seja salvo no banco 
	private BigDecimal valorTotal = BigDecimal.ZERO;
	@ManyToOne
	private Cliente cliente;
						  //atributo		  o cascade serve para falar para a jpa tbm da um insert na tabela relacionada (bom pra evitar a quantidade de classes DAO)
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) //falando pra jpa que já existe esse relacionamento na outra classe atráves do atribudo pedido
	private List<ItemPedido> itens = new ArrayList<>(); //sempre iniciar a lista por boa pratica
	
    public Pedido() {

    }
    

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
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
	
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
    
	
    
}
