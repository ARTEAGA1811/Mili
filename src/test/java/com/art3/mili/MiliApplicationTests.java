package com.art3.mili;

import com.art3.mili.modelo.dao.IUsuarioDAO;
import com.art3.mili.modelo.entidad.Usuario;
import com.art3.mili.modelo.servicio.IUsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MiliApplicationTests {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Test
    void crearUsuarioTest() {
        Usuario user1 = new Usuario();
        user1.setNombreUsuario("test2");
        user1.setClave(encoder.encode("test2"));

        //Me retorna un usuario
        Usuario usuarioRetorno = usuarioService.crearUsuario(user1);

        assertTrue(usuarioRetorno.getClave().equalsIgnoreCase(user1.getClave()));


    }

}
