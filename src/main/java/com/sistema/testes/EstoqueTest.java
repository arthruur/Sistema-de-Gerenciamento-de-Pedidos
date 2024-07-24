package main.java.com.sistema.testes;

import main.java.com.sistema.exception.ProdutoNaoCadastrou;
import main.java.com.sistema.exception.QuantidadeNaoAlteradaException;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class EstoqueTest {

    private Estoque estoque;

    @Before
    public void setUp() {
        estoque = Estoque.getInstance();
        estoque.limparEstoque(); // Limpa o estoque antes de cada teste
    }

    @Test
    public void testCadastrarProduto() throws ProdutoNaoCadastrou {
        Produto produto = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");

        assertNotNull(produto);
        assertEquals("Smartphone", produto.getNome());
        assertEquals(999.99, produto.getPreco(), 0.01);
        assertEquals("Smartphone de última geração", produto.getDescricao());
        assertEquals("Eletrônico", produto.getCategoria());

        assertEquals((Integer) 10, estoque.getQuantidade(produto));
    }

    @Test(expected = ProdutoNaoCadastrou.class)
    public void testCadastrarProdutoNomeInvalido() throws ProdutoNaoCadastrou {
        estoque.cadastrarProduto("", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
    }

    @Test(expected = ProdutoNaoCadastrou.class)
    public void testCadastrarProdutoPrecoInvalido() throws ProdutoNaoCadastrou {
        estoque.cadastrarProduto("Smartphone", -1, "Smartphone de última geração", 10, "ProdutoEletronico");
    }

    @Test
    public void testAdicionarQuantidade() throws ProdutoNaoCadastrou, QuantidadeNaoAlteradaException {
        Produto produto = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
        assertTrue(estoque.adicionarQuantidade(produto, 5));
        assertEquals((Integer) 15, estoque.getQuantidade(produto));
    }

    @Test(expected = QuantidadeNaoAlteradaException.class)
    public void testAdicionarQuantidadeInvalida() throws ProdutoNaoCadastrou, QuantidadeNaoAlteradaException {
        Produto produto = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
        estoque.adicionarQuantidade(produto, -5);
    }

    @Test
    public void testDiminuirQuantidade() throws ProdutoNaoCadastrou, QuantidadeNaoAlteradaException {
        Produto produto = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
        assertTrue(estoque.diminuirQuantidade(produto, 5));
        assertEquals((Integer) 5, estoque.getQuantidade(produto));
    }

    @Test(expected = QuantidadeNaoAlteradaException.class)
    public void testDiminuirQuantidadeInvalida() throws ProdutoNaoCadastrou, QuantidadeNaoAlteradaException {
        Produto produto = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
        estoque.diminuirQuantidade(produto, 15);
    }

    @Test
    public void testRemoverProduto() throws ProdutoNaoCadastrou {
        Produto produto = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
        assertTrue(estoque.removerProduto(produto));
        assertNull(estoque.getQuantidade(produto));
    }

    @Test
    public void testListarProdutos() throws ProdutoNaoCadastrou {
        Produto produto1 = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
        Produto produto2 = estoque.cadastrarProduto("Camisa", 49.99, "Camisa de algodão", 20, "ProdutoRoupa");

        Map<Produto, Integer> produtos = estoque.getProdutos();
        assertEquals(2, produtos.size());
        assertTrue(produtos.containsKey(produto1));
        assertTrue(produtos.containsKey(produto2));
    }

    @Test
    public void testGetProduto() throws ProdutoNaoCadastrou {
        Produto produto = estoque.cadastrarProduto("Smartphone", 999.99, "Smartphone de última geração", 10, "ProdutoEletronico");
        Produto produtoBuscado = estoque.getProduto("Smartphone");

        assertNotNull(produtoBuscado);
        assertEquals("Smartphone", produtoBuscado.getNome());
    }
}
