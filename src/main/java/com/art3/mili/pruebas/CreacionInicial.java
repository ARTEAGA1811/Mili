package com.art3.mili.pruebas;

import com.art3.mili.modelo.dao.IUsuarioDAO;
import com.art3.mili.modelo.entidad.Usuario;
import com.art3.mili.modelo.servicio.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


@Component
public class CreacionInicial {
    @Autowired
    UsuarioServiceImpl usuarioService;

    @EventListener(ApplicationReadyEvent.class)
    public  void crearDatosIniciales(){

//        System.out.println("Creacion inicial para la base de datos");
//        //Creacion inicial de datos para la base de datos
//
//        //Agregar usuarios.
//        Usuario user1 = new Usuario();
//        user1.setNombreUsuario("admin");
//        user1.setClave("admin");
//
//        Usuario user2 = new Usuario();
//        user2.setNombreUsuario("david");
//        user2.setClave("arteaga");
//
//        usuarioService.crearUsuario(user1);
//        usuarioService.crearUsuario(user2);

    }
}
