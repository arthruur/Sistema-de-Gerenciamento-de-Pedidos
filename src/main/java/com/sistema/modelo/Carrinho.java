package main.java.com.sistema.modelo;
import java.util.Iterator;
import java.util.List;



public class Carrinho {
    private List<CarrinhoItem> itens;

    public void adicionarProduto(Produto produto, int quantidade) {
        // Lógica para adicionar produto
        CarrinhoItem item = new CarrinhoItem(produto, quantidade);
        itens.add(item);
    }

    public void removerProduto(Produto produto) {
        // Lógica para remover produto
        Iterator<CarrinhoItem> iterator = itens.iterator();
        while (iterator.hasNext()) {
            CarrinhoItem item = iterator.next();
            if (item.geProduto().equals(produto)){
                iterator.remove();
                break;
            }
        }
    }

    public double getValorTotal() {
        return itens.stream().mapToDouble(CarrinhoItem::getPrecoTotal).sum();
    }

    // Construtor, getters e setters
}
