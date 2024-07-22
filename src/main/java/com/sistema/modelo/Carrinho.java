package main.java.com.sistema.modelo;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> itens;

    public Carrinho() {
        this.itens = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (itens.containsKey(produto)) {
            // Se o produto já estiver no carrinho, atualiza a quantidade
            itens.put(produto, itens.get(produto) + quantidade);
        } else {
            // Se o produto não estiver no carrinho, adiciona com a quantidade especificada
            itens.put(produto, quantidade);
        }
    }

    public void removerProduto(Produto produto) {
        if (itens.containsKey(produto)) {
            itens.remove(produto);
        }
    }

    public double getValorTotal() {
        return itens.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPreco() * entry.getValue())
                .sum();
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Produto, Integer> itens) {
        this.itens = itens;
    }

    public void esvaziar() {
        itens.clear();
    }
}
