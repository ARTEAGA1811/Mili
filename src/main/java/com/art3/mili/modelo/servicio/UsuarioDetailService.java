package com.art3.mili.modelo.servicio;

import com.art3.mili.modelo.dao.IUsuarioDAO;
import com.art3.mili.modelo.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Debo implementar.
@Service
public class UsuarioDetailService implements UserDetailsService {

    @Autowired
    IUsuarioDAO usuarioDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Aqui le decimos a spring de donde sacamos los nombre de usuario, contrasenas,etc.
        //Lo que hacemos ahora es obtener los datos de la base de datos.
        Usuario usObt = usuarioDAO.findUsuarioByNombreUsuario(username);

        //Agregamos los roles
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));

        //Debemos crear un userDetails.
        UserDetails userDet = new User(usObt.getNombreUsuario(), usObt.getClave(), roles);
        return userDet;


    }
}
