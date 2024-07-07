package main.java.com.sistema.modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Estoque {
    private static Estoque instance;
    private Map<Produto, Integer> produtos; // ou estoque?

    private Estoque(){
        produtos = new HashMap<>();
    }

    public static synchronized Estoque getInstance() {
        if (instance == null) {
            instance = new Estoque();
        }
        return instance;

    }
    
    // provavelmente será modificado para usar factory method
    public synchronized Produto cadastrarProduto(String nome, double preco, String desc, int qtd){
        Produto produto = new Produto(nome, preco, desc);
        produtos.put(produto, qtd);
        return produto;
    }

    public synchronized boolean adicionarQuantidade(Produto produto, int qtd) {
        // refazer try e catch
        if (produtos.containsKey(produto)) {
            produtos.put(produto, produtos.get(produto) + qtd);
            return true;
        }
        return false;
    }

    public synchronized boolean removerQuantidade(Produto produto, int qtd){
        int quantidadeAtual = produtos.get(produto);

        if (quantidadeAtual < qtd){
            return false;
        }

        int novaQtd = quantidadeAtual - qtd;
        produtos.put(produto, novaQtd);
        return true;
    }

    public synchronized Iterator<Map.Entry<Produto, Integer>> listarProdutos(){
        return produtos.entrySet().iterator();
    }
    // Construtor, getters e setters
    public synchronized Map<Produto,Integer> getProdutos(){
        return produtos;
    }
}
