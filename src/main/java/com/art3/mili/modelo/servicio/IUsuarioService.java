package com.art3.mili.modelo.servicio;

import com.art3.mili.modelo.entidad.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public Optional<Usuario> validarCredenciales(String nombreusuario, String clave);
    public Optional<Usuario> obtenerPorId(int id);
    public Optional<List<Usuario>> obtenerTodos();
    public Usuario crearUsuario(Usuario usuario);
    public boolean actualizarUsuario(Usuario usuario);
    public boolean eliminarUsuarioPorId(int id);
}
