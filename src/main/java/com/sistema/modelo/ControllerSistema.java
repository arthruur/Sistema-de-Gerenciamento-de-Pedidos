package main.java.com.sistema.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

import main.java.com.sistema.exception.LoginFalhouException;
import main.java.com.sistema.exception.UsuarioNaoCadastrouException;

public class ControllerSistema implements Serializable{
    private static final long serialVersionUID = 1L;
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

    
public String salvarDados(String nomeArquivo) throws IOException {
    File file = new File(nomeArquivo);
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
        out.writeObject(this);
        String caminhoAbsoluto = file.getAbsolutePath();
        System.out.println("Dados salvos com sucesso no caminho: " + caminhoAbsoluto);
        return caminhoAbsoluto;
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Arquivo não encontrado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        throw e;
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Erro de I/O: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        throw e;
    }
}
        
public String carregarDados(String nomeArquivo) throws IOException, ClassNotFoundException {
    File file = new File(nomeArquivo);
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
        Object objetoCarregado = in.readObject();
        if (objetoCarregado instanceof ControllerSistema) {
            this.atualizarEstado((ControllerSistema) objetoCarregado);
            String caminhoAbsoluto = file.getAbsolutePath();
            System.out.println("Dados carregados com sucesso do caminho: " + caminhoAbsoluto);
            return caminhoAbsoluto;
        } else {
            throw new ClassCastException("O objeto carregado não é uma instância de ControllerSistema.");
        }
    } catch (ClassCastException e) {
        JOptionPane.showMessageDialog(null, "Erro de classe ao carregar o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        throw e;
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Erro de I/O ao carregar o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        throw e;
    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Classe não encontrada ao carregar o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        throw e;
    }
}

public void atualizarEstado(ControllerSistema sistemaCarregado) {
    this.admin = sistemaCarregado.admin;
    this.clientes = sistemaCarregado.clientes;
    this.clienteAtivo = sistemaCarregado.clienteAtivo;
    this.estoque = sistemaCarregado.estoque;
}
}
