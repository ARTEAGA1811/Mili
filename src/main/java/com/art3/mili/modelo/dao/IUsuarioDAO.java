package com.art3.mili.modelo.dao;

import com.art3.mili.modelo.entidad.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUsuarioDAO extends CrudRepository<Usuario,Integer> {
    public Optional<Usuario> findUsuarioByNombreUsuarioAndClave(String nombreUsuario, String clave);
    public Usuario findUsuarioByNombreUsuario(String nombreUsuario);

//    //@Modifying is for telling spring-data-jpa that this query is an update operation and it requires executeUpdate() not executeQuery().
//    @Modifying
//    @Query("UPDATE Usuario u SET u.nombreUsuario = ?1, u.clave = ?2 where u.idUsuario = ?3")
//    public void actualizarUsuario(String nombreUsuario, String clave, int id);

}
