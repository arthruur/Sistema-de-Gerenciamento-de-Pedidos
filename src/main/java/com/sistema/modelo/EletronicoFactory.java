package main.java.com.sistema.modelo;

public class EletronicoFactory implements ProdutoFactory {
    
    public EletronicoFactory(){
    
    }

    @Override
    public Produto criarProduto(String nome, double preco, String descricao){
        return new ProdutoEletronico(nome, preco, descricao);
    }
}
