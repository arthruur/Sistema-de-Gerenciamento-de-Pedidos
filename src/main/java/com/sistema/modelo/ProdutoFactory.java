package main.java.com.sistema.modelo;

public interface ProdutoFactory {
    
    Produto criarProduto(String nome, double preco, String descricao);
}
