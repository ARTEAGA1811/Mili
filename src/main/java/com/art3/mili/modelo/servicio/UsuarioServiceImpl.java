package com.art3.mili.modelo.servicio;

import com.art3.mili.modelo.dao.IUsuarioDAO;
import com.art3.mili.modelo.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public Optional<Usuario> validarCredenciales(String nombreUsuario, String clave) {
        return usuarioDAO.findUsuarioByNombreUsuarioAndClave(nombreUsuario, clave);
    }

    @Override
    public Optional<Usuario> obtenerPorId(int id) {
        return usuarioDAO.findById(id);
    }

    @Override
    public Optional<List<Usuario>> obtenerTodos() {
        return Optional.of((List<Usuario>) usuarioDAO.findAll());
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioBaseDatos = usuarioDAO.findById(usuario.getIdUsuario());
        if(usuarioBaseDatos.isPresent()){
            usuarioBaseDatos.get().setNombreUsuario(usuario.getNombreUsuario());
            usuarioBaseDatos.get().setClave(usuario.getClave());
            usuarioDAO.save(usuarioBaseDatos.get());
            return true;
        }
        return false;

    }

    @Override
    public boolean eliminarUsuarioPorId(int id) {
        try{
            usuarioDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
