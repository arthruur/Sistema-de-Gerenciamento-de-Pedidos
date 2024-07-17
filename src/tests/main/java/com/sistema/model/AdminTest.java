package tests.main.java.com.sistema.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.sistema.modelo.*;

public class AdminTest {

    private Admin admin;
    private Estoque estoque;
    
    @BeforeEach
    public void setUp() {
        estoque = Estoque.getInstance();
        estoque.limparEstoque();
        admin = new Admin(estoque);
        admin.cadastrarProduto("Produto A", 10.0, 100, "Descrição do Produto A");
    }

    @Test
    public void testCadastrarProduto() {
        // Verifica se o produto foi cadastrado corretamente
        Produto produto = estoque.getProduto("Produto A");
        assertNotNull(produto);
        assertEquals("Produto A", produto.getNome());
        assertEquals(10.0, produto.getPreco());
        assertEquals(100, estoque.getQuantidade(produto));
        assertEquals("Descrição do Produto A", produto.getDescricao());
    }

    @Test
    public void testAdicionarProduto() {
        // Adiciona mais unidades do produto ao estoque
        Produto produto = estoque.getProduto("Produto A"); 
        admin.adicionarProduto(produto, 50);
        assertEquals(150, estoque.getQuantidade(produto));
    }

    @Test
    public void testExcluirProduto() {
        // Exclui o produto do estoque
        Produto produto = estoque.getProduto("Produto A");
        admin.excluirProduto(produto);
        assertNull(estoque.getProduto("Produto A"));
    }

    @Test
    public void testCadastrarProdutoNovo() {
        // Cadastra um novo produto e verifica se foi adicionado corretamente
        admin.cadastrarProduto("Produto B", 20.0, 200, "Descrição do Produto B");
        Produto produtoB = estoque.getProduto("Produto B");
        assertNotNull(produtoB);
        assertEquals("Produto B", produtoB.getNome());
        assertEquals(20.0, produtoB.getPreco());
        assertEquals(200, estoque.getQuantidade(produtoB));
        assertEquals("Descrição do Produto B", produtoB.getDescricao());
    }
}

