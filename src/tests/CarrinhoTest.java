package tests; 

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
    }

    @Test
    public void testAdicionarProduto() {
        carrinho.adicionarProduto(produto, 2);
        List<CarrinhoItem> itens = carrinho.getItens();
        assertEquals(1, itens.size());
        assertEquals(produto, itens.get(0).getProduto());
        assertEquals(2, itens.get(0).getQuantidade());
    }

    @Test
    public void testRemoverProduto() {
        carrinho.adicionarProduto(produto, 2);
        carrinho.removerProduto(produto);
        List<CarrinhoItem> itens = carrinho.getItens();
        assertTrue(itens.isEmpty());
    }

    @Test
    public void testGetValorTotal() {
        carrinho.adicionarProduto(produto, 2);
        assertEquals(20.0, carrinho.getValorTotal());
    }
}
