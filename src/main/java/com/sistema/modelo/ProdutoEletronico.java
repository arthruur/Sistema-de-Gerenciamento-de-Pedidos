package main.java.com.sistema.modelo;

public class ProdutoEletronico extends Produto {
    

    public ProdutoEletronico(String nome, double preco, String descricao){
        super(nome, preco, descricao);
    }

    public String getCategoria(){
        return "Eletrônico";
    }
}
