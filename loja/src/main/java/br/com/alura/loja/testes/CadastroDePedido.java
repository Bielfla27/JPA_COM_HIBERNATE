package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ClienteDAO;
import br.com.alura.loja.DAO.PedidoDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.Vo.RelatorioDeVendasVo;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUltil;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUltil.getEntityManager();
		ProdutoDAO produtroDao = new ProdutoDAO(em);
		Produto produto = produtroDao.buscarPorID(1l);
		Produto produto1 = produtroDao.buscarPorID(2l);
		ClienteDAO clienteDao = new ClienteDAO(em);
		Cliente cliente = clienteDao.buscarPorID(1l);
		
		em.getTransaction().begin(); //inicia a tranza��o
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(5, pedido, produto1));
		PedidoDAO pedidoDao = new PedidoDAO(em);
		pedidoDao.cadastrar(pedido);
		em.getTransaction().commit(); 
		 
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("VALOR TOTAL: " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);
	}
	
	private static void popularBancoDeDados() {
		Categoria Celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Poco", "Bom demais", new BigDecimal("800"), Celulares );
		Produto celular1 = new Produto("Xiaomi 7", "Bom demais", new BigDecimal("650"), Celulares );
		Cliente cliente = new Cliente("Luiz doido" , "123456"); 
		
		EntityManager em = JPAUltil.getEntityManager();
		ProdutoDAO produtroDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		
		//estou inserindo o celular na tabela mapeei na classe Produto
		em.getTransaction().begin(); //inicia a tranza��o
		categoriaDao.cadastrar(Celulares);
		produtroDao.cadastrar(celular);;
		produtroDao.cadastrar(celular1);
		clienteDao.cadastrar(cliente);
		em.getTransaction().commit();
		em.close();
	}

}
