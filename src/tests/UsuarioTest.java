package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("usuario", "senha");
    }

    @Test
    public void testGetNome() {
        assertEquals("usuario", usuario.getNome());
    }

    @Test
    public void testGetSenha() {
        assertEquals("senha", usuario.getSenha());
    }

    @Test
    public void testSetNome() {
        usuario.setNome("novoUsuario");
        assertEquals("novoUsuario", usuario.getNome());
    }

    @Test
    public void testSetSenha() {
        usuario.setSenha("novaSenha");
        assertEquals("novaSenha", usuario.getSenha());
    }
}
