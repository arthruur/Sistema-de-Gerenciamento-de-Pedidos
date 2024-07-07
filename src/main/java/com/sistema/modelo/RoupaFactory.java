package main.java.com.sistema.modelo;

public class RoupaFactory implements ProdutoFactory {
    
    public RoupaFactory(){

    }

    public Produto criarProduto(String nome, double preco, String descricao){
        return new ProdutoRoupa(nome, preco, descricao);
    }
}
