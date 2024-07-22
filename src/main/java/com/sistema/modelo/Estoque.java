package main.java.com.sistema.modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import main.java.com.sistema.exception.ProdutoNaoCadastrou;
import main.java.com.sistema.exception.QuantidadeNaoAlteradaException;

public class Estoque {
    private static Estoque instance;
    private Map<Produto, Integer> produtos;

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
    public synchronized Produto cadastrarProduto(String nome, double preco, String desc, int qtd)throws ProdutoNaoCadastrou{

        if (nome == null || nome.isEmpty()){
            throw new ProdutoNaoCadastrou("É necessário preencher o campo nome");
        }
        
        if (preco <= 0){
            throw new ProdutoNaoCadastrou("É necessário preencher o campo preco");
        }

        Produto produto = new ProdutoEletronico(nome, preco, desc);
        produtos.put(produto, qtd);
        return produto;

    }

    public synchronized boolean adicionarQuantidade(Produto produto, int qtd)throws QuantidadeNaoAlteradaException{
        if (produtos.containsKey(produto)) {
            if (qtd > 0) {
                produtos.put(produto, produtos.get(produto) + qtd);
                return true;
            } else {
                throw new QuantidadeNaoAlteradaException("A quantidade deve ser maior que 0.");
            }
        }
        return false;
    }

    public synchronized boolean diminuirQuantidade(Produto produto, int qtd) throws QuantidadeNaoAlteradaException{
        if (produtos.containsKey(produto)) {
            int quantidadeAtual = produtos.get(produto);
            if (qtd <= quantidadeAtual) {
                produtos.put(produto, quantidadeAtual - qtd);
                return true;
            } else {
                throw new QuantidadeNaoAlteradaException("Quantidade a ser removida excede a quantidade disponível no estoque.");
            }
        }
        return false;
    }

    // Método para remover um produto do estoque
    public synchronized boolean removerProduto(Produto produto) {
        if (produtos.containsKey(produto)) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }   

    public synchronized Iterator<Map.Entry<Produto, Integer>> listarProdutos(){
        return produtos.entrySet().iterator();
    }

    public synchronized Map<Produto,Integer> getProdutos(){
        return produtos;
    }

    // Método para obter a quantidade de um produto específico
    public synchronized Integer getQuantidade(Produto produto) {
        return produtos.get(produto);
    }


    public synchronized Produto getProduto(String nome) {
        for (Produto produto : produtos.keySet()) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }
    
    //para limpar o estoque antes de cada teste
    public synchronized void limparEstoque(){
        produtos.clear();
    }
}
