package main.java.com.sistema.testes;

import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.GerenciaClientes;
import main.java.com.sistema.exception.UsuarioNaoCadastrouException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GerenciaClientesTest {

    private GerenciaClientes gerenciaClientes;

    @Before
    public void setUp() {
        gerenciaClientes = new GerenciaClientes();
    }

    @Test
    public void testCadastrarClienteDadosValidos() {
        try {
            Cliente cliente = gerenciaClientes.cadastrarCliente(
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
    public void testCadastrarClienteLoginExistente() {
        try {
            gerenciaClientes.cadastrarCliente(
                "login1", "senha1", "Nome Completo", "123.456.789-00", "Endereço Exemplo", "123456789"
            );
            // Tentar cadastrar um cliente com o mesmo login
            gerenciaClientes.cadastrarCliente(
                "login1", "senha2", "Outro Nome", "987.654.321-00", "Outro Endereço", "987654321"
            );
            fail("Deveria lançar exceção ao cadastrar cliente com login existente.");
        } catch (UsuarioNaoCadastrouException e) {
            assertEquals("Não foi possível cadastrar o usuário, login já existente.", e.getMessage());
        }
    }

    @Test
    public void testCadastrarClienteCamposVazios() {
        try {
            // Tentar cadastrar um cliente com campos vazios
            gerenciaClientes.cadastrarCliente(
                "", "", "", "", "", ""
            );
            fail("Deveria lançar exceção ao cadastrar cliente com campos vazios.");
        } catch (UsuarioNaoCadastrouException e) {
            assertEquals("Não foi possível cadastrar o usuário, preencha todos os campos", e.getMessage());
        }
    }

    @Test
    public void testGetCliente() {
        try {
            Cliente cliente = gerenciaClientes.cadastrarCliente(
                "login1", "senha1", "Nome Completo", "123.456.789-00", "Endereço Exemplo", "123456789"
            );
            Cliente retrievedCliente = gerenciaClientes.getCliente("login1");
            assertNotNull(retrievedCliente);
            assertEquals(cliente.getLogin(), retrievedCliente.getLogin());
            assertEquals(cliente.getNome(), retrievedCliente.getNome());
        } catch (UsuarioNaoCadastrouException e) {
            fail("Não deveria lançar exceção ao obter cliente: " + e.getMessage());
        }
    }
}
