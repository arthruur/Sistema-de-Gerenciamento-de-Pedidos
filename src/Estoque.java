import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void modificarQtdDeProduto(Produto produto, int novaQuantidade) {
        produto.setQuantidadeEmEstoque(novaQuantidade);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    // Construtor, getters e setters
}
