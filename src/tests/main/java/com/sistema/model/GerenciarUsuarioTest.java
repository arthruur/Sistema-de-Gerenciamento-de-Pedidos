package tests.main.java.com.sistema.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.com.sistema.modelo.*;

public class GerenciarUsuarioTest {

    private GerenciarClientes gerenciarUsuario;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        gerenciarUsuario = new GerenciarClientes();
        cliente = new Cliente("Cliente A");
    }

    @Test
    public void testCadastrarUsuario() {
        gerenciarUsuario.cadastrarUsuario(cliente);
        assertEquals(1, gerenciarUsuario.getUsuarios().size());
        assertEquals(cliente, gerenciarUsuario.getUsuarios().get(0));
    }

    @Test
    public void testConhecerUsuario() {
        gerenciarUsuario.cadastrarUsuario(cliente);
        Cliente encontrado = gerenciarUsuario.conhecerUsuario("Cliente A");
        assertEquals(cliente, encontrado);
    }
}
