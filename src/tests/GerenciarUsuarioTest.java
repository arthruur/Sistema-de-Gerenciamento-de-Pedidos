package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GerenciarUsuarioTest {

    @Test
    public void testConhecerUsuario() {
        GerenciarUsuario gerenciarUsuario = new GerenciarUsuario();
        Usuario usuario = new Usuario("user1");
        gerenciarUsuario.setUsuario(usuario);

        assertEquals(usuario, gerenciarUsuario.getUsuario());
    }

    @Test
    public void testCadastrarUsuario() {
        GerenciarUsuario gerenciarUsuario = new GerenciarUsuario();
        Usuario usuario = new Usuario("user1");
        gerenciarUsuario.cadastrarUsuario(usuario);

        assertTrue(gerenciarUsuario.getUsuarios().contains(usuario));
    }
}
