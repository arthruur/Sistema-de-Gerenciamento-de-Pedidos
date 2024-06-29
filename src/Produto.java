public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private String descricao;
    
    
    public void setQuantidadeEmEstoque(int novaQuantidade) {
        quantidadeEmEstoque = novaQuantidade; 
    }


    public double getPreco() {
        return preco; 
    }

    // Construtor, getters e setters
}
