import java.util.List;

public class Carrinho {
    private List<CarrinhoItem> itens;

    public void adicionarProduto(Produto produto, int quantidade) {
        // Lógica para adicionar produto
    }

    public void removerProduto(Produto produto) {
        // Lógica para remover produto
    }

    public double getValorTotal() {
        return itens.stream().mapToDouble(CarrinhoItem::getPrecoTotal).sum();
    }

    // Construtor, getters e setters
}
