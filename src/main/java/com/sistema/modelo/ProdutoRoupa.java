package main.java.com.sistema.modelo;

public class ProdutoRoupa extends Produto {
    
    public ProdutoRoupa(String nome, double preco, String descricao){
        super(nome, preco, descricao);
    }

    public String getCategoria(){
        return "Roupa";
    }
}
