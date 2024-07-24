package main.java.com.sistema.testes;

import org.junit.Before;
import org.junit.Test;

import main.java.com.sistema.exception.ProdutoNaoCadastrou;
import main.java.com.sistema.exception.QuantidadeNaoAlteradaException;
import main.java.com.sistema.modelo.Admin;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;
import main.java.com.sistema.modelo.Cliente; 
import main.java.com.sistema.modelo.Carrinho;
import main.java.com.sistema.modelo.Pagamento;
import main.java.com.sistema.modelo.Pedido; 
import main.java.com.sistema.modelo.ProdutoEletronico;

import static org.junit.Assert.*;

public class AdminTest {

    private Admin admin;
    private Estoque estoque;
    private Produto produto;
    private Cliente cliente;
    private Carrinho carrinho;
    private Pagamento pagamento;
    private Pedido pedido;

    @Before
    public void setUp() throws Exception {
        estoque = Estoque.getInstance();
        admin = new Admin(estoque);
        produto = new ProdutoEletronico("Smartphone", 999.99, "Smartphone de última geração");
        estoque.cadastrarProduto(produto.getNome(), produto.getPreco(), produto.getDescricao(), 10, produto.getCategoria());
        admin.adicionarProduto(produto, 10); 
        cliente = new Cliente("joao123", "senha123", "João", "123.456.789-00", "Rua A, 123", "987654321");
        carrinho = cliente.getCarrinho();
        carrinho.adicionarProduto(produto, 2);
        pagamento = new Pagamento("Cartão de Crédito", 1999.98);
        pedido = new Pedido(carrinho, cliente, pagamento);
    }

    @Test
    public void testCadastrarProduto() throws ProdutoNaoCadastrou, QuantidadeNaoAlteradaException {
        Produto novoProduto = admin.cadastrarProduto("Notebook", 2999.99, 5, "Notebook gamer", "Eletrônico");
        assertNotNull(novoProduto);
        assertEquals("Notebook", novoProduto.getNome());
        assertEquals(2999.99, novoProduto.getPreco(), 0.01);
        assertEquals(5, estoque.getQuantidade(novoProduto).intValue());
    }

    @Test
    public void testExcluirProduto() {
        // Cadastro do produto e verificação
        Produto produtoCadastrado = null;
        try {
            produtoCadastrado = admin.cadastrarProduto("Smartphone", 999.99, 10, "Smartphone de última geração", "ProdutoEletronico");
        } catch (ProdutoNaoCadastrou e) {
            fail("Erro ao cadastrar produto: " + e.getMessage());
        }

        // Verifique se o produto está no estoque
        assertNotNull(estoque.getProduto(produtoCadastrado.getNome()));

        // Excluir o produto
        assertTrue(admin.excluirProduto(produtoCadastrado));

        // Verifique se o produto foi removido
        assertNull(estoque.getProduto(produtoCadastrado.getNome()));
    }
    
    @Test
    public void testAdicionarProduto() {
        try {
            // Primeiro cadastramos o produto no estoque
            Produto produtoCadastrado = admin.cadastrarProduto("Smartphone", 1000.0, 10, "Um ótimo smartphone", "ProdutoEletronico");
            
            // Depois adicionamos quantidade ao produto
            boolean adicionado = admin.adicionarProduto(produtoCadastrado, 5);
            assertTrue(adicionado);

            // Verificamos a quantidade do produto no estoque
            int quantidade = estoque.getQuantidade(produtoCadastrado);
            assertEquals(15, quantidade); // 10 + 5 = 15
        } catch (ProdutoNaoCadastrou | QuantidadeNaoAlteradaException e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }
    @Test
    public void testDiminuirProduto() {
        // Primeiro, cadastrar o produto no estoque
        try {
            admin.cadastrarProduto(produto.getNome(), produto.getPreco(), 10, produto.getDescricao(), produto.getCategoria());
        } catch (ProdutoNaoCadastrou e) {
            fail("Erro ao cadastrar produto: " + e.getMessage());
        }
        
        // Verificar se o produto foi cadastrado corretamente
        assertEquals(10, estoque.getQuantidade(produto).intValue());
        
        // Diminuir a quantidade do produto
        try {
            admin.diminuirProduto(produto, 2);
        } catch (QuantidadeNaoAlteradaException e) {
            fail("Erro ao diminuir a quantidade do produto: " + e.getMessage());
        }
        
        // Verificar se a quantidade foi diminuída corretamente
        assertEquals(8, estoque.getQuantidade(produto).intValue());
    }
    
    @Test
    public void testProcessarEAprovarPedido() {
        assertEquals("Novo", pedido.getEstado());
        admin.processarEAprovarPedido(pedido);
        assertEquals("Processando", pedido.getEstado());
        admin.processarEAprovarPedido(pedido);
        assertEquals("Enviado", pedido.getEstado());
        admin.processarEAprovarPedido(pedido);
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    public void testAcompanharStatusDoPedido() {
        admin.processarEAprovarPedido(pedido); // Processa o pedido para o próximo estado
        assertEquals("Processando", admin.acompanharStatusDoPedido(pedido));
    }

    @Test
    public void testGetSenha() {
        assertEquals("1234", admin.getSenha());
    }

    @Test
    public void testAdicionarPedido() {
        admin.adicionarPedido(pedido);
        assertTrue(admin.getPedidos().contains(pedido));
    }
}
