package com.art3.mili.pruebas;

import com.art3.mili.modelo.dao.IUsuarioDAO;
import com.art3.mili.modelo.entidad.Usuario;
import com.art3.mili.modelo.servicio.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class CreacionInicial {
    public static void crearDatosIniciales(){
        UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

        //Creacion inicial de datos para la base de datos

        //Agregar usuarios.
        Usuario user1 = new Usuario();
        user1.setNombreUsuario("admin");
        user1.setClave("admin");

        Usuario user2 = new Usuario();
        user2.setNombreUsuario("david");
        user2.setClave("arteaga");

        usuarioService.crearUsuario(user1);
        usuarioService.crearUsuario(user2);

    }
}
