package main.java.com.sistema.modelo;

import main.java.com.sistema.exception.LoginFalhouException;
import main.java.com.sistema.exception.UsuarioNaoCadastrouException;

public class ControllerSistema {
    private Admin admin; 
    private GerenciaClientes clientes;
    private Cliente clienteAtivo;
    private Estoque estoque = Estoque.getInstance();


    public ControllerSistema(){
        this.clientes = new GerenciaClientes();
        this.admin = new Admin(estoque); 
    }

    public Cliente fazerLogin(String login, String senha) throws LoginFalhouException{
        Cliente cliente = clientes.getCliente(login);
        if (cliente == null || !cliente.getSenha().equals(senha)) {
            throw new LoginFalhouException("Não foi possível efetuar o login");
        }
        clienteAtivo = cliente;
        return cliente;

    }

    public Cliente getClienteAtivo() {
        return clienteAtivo;
    }

    public Cliente cadastrarCliente(String login, String senha, String nome, String cpf, String endereço, String telefone)throws UsuarioNaoCadastrouException{
        return clientes.cadastrarCliente(login, senha, nome, cpf, endereço, telefone); 
    }

    public Admin getAdmin(){
        return admin; 
    }
    
    public GerenciaClientes getClientes(){
        return clientes; 
    }
}
