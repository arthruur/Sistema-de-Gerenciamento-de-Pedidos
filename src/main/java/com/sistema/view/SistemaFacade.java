package main.java.com.sistema.view;

import java.util.Iterator;
import java.util.LinkedList;
import main.java.com.sistema.exception.LoginFalhouException;
import main.java.com.sistema.exception.UsuarioNaoCadastrouException;
import main.java.com.sistema.modelo.Admin;
import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.ControllerSistema;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.GerenciaClientes;
import main.java.com.sistema.modelo.Produto;

public class SistemaFacade {
   private ControllerSistema cs; 

   public SistemaFacade(ControllerSistema cs) {
      this.cs = cs; 
   }

   public Produto cadastrarProduto(String nome, double preco, int quantidade, String descricao) {
      return cs.getAdmin().cadastrarProduto(nome, preco, quantidade, descricao);
   }

   public boolean adicionarProduto(Produto produto, int quantidade) {
      return cs.getAdmin().adicionarProduto(produto, quantidade);
   }

   public boolean removerProduto(Produto produto) {
      return Estoque.getInstance().removerProduto(produto);
   }

   public Produto getProduto(String nome) {
      return Estoque.getInstance().getProduto(nome);
   }

   public Integer getQuantidade(Produto produto) {
      return Estoque.getInstance().getQuantidade(produto);
   }

   public void limparEstoque() {
      Estoque.getInstance().limparEstoque();
   }
   public void entrarComoAdmin(String senha) throws LoginFalhouException {
      if(!cs.getAdmin().getSenha().equals(senha)){
         throw new LoginFalhouException("Senha de Admin incorreta."); 
     };
}
   public Cliente cadastrarCliente(String login, String senha, String nome, String cpf, String endereço, String telefone)throws UsuarioNaoCadastrouException{
      return cs.cadastrarCliente(login, senha, nome, cpf, endereço, telefone); 
   }

   public GerenciaClientes getClientes(){
      return cs.getClientes();
   }

   public ControllerSistema getController(){
      return cs; 
   }


}
