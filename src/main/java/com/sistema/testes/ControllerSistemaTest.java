package main.java.com.sistema.testes;

import main.java.com.sistema.modelo.Admin;
import main.java.com.sistema.modelo.Carrinho;
import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.ControllerSistema;
import main.java.com.sistema.modelo.GerenciaClientes;
import main.java.com.sistema.exception.LoginFalhouException;
import main.java.com.sistema.exception.UsuarioNaoCadastrouException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

public class ControllerSistemaTest {

    private ControllerSistema controllerSistema;

    @Before
    public void setUp() {
        controllerSistema = new ControllerSistema();
    }

    @Test
    public void testCadastrarCliente() {
        try {
            Cliente cliente = controllerSistema.cadastrarCliente(
                "login1", "senha1", "Nome Completo", "123.456.789-00", "Endereço Exemplo", "123456789"
            );
            assertNotNull(cliente);
            assertEquals("login1", cliente.getLogin());
            assertEquals("Nome Completo", cliente.getNome());
        } catch (UsuarioNaoCadastrouException e) {
            fail("Não deveria lançar exceção com dados válidos: " + e.getMessage());
        }
    }

    @Test
    public void testFazerLoginSucesso() {
        try {
            controllerSistema.cadastrarCliente(
                "login1", "senha1", "Nome Completo", "123.456.789-00", "Endereço Exemplo", "123456789"
            );
            Cliente cliente = controllerSistema.fazerLogin("login1", "senha1");
            assertNotNull(cliente);
            assertEquals("login1", cliente.getLogin());
            assertEquals("Nome Completo", cliente.getNome());
        } catch (UsuarioNaoCadastrouException | LoginFalhouException e) {
            fail("Não deveria lançar exceção com login válido: " + e.getMessage());
        }
    }

    @Test
    public void testFazerLoginFalha() {
        try {
            controllerSistema.cadastrarCliente(
                "login1", "senha1", "Nome Completo", "123.456.789-00", "Endereço Exemplo", "123456789"
            );
            // Tentando login com senha errada
            controllerSistema.fazerLogin("login1", "senhaErrada");
            fail("Deveria lançar exceção com senha incorreta.");
        } catch (LoginFalhouException e) {
            assertEquals("Não foi possível efetuar o login", e.getMessage());
        } catch (UsuarioNaoCadastrouException e) {
            fail("Não deveria lançar exceção ao cadastrar cliente: " + e.getMessage());
        }
    }

    @Test
    public void testSalvarDados() {
        try {
            // Cadastrar um cliente e salvar os dados
            controllerSistema.cadastrarCliente(
                "login1", "senha1", "Nome Completo", "123.456.789-00", "Endereço Exemplo", "123456789"
            );
            String caminhoArquivo = controllerSistema.salvarDados("dadosTeste.ser");

            // Verificar se o arquivo foi criado
            File arquivo = new File(caminhoArquivo);
            assertTrue(arquivo.exists());
        } catch (IOException | UsuarioNaoCadastrouException e) {
            fail("Não deveria lançar exceção ao salvar dados: " + e.getMessage());
        }
    }

}