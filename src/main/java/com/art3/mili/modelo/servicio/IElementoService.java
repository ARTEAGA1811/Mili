package com.art3.mili.modelo.servicio;

import com.art3.mili.modelo.entidad.Elemento;

import java.util.List;

public interface IElementoService {
    public Elemento crearElemento(Elemento elemento);
    public List<Elemento> obtenerTodosPorIdUsuario();

}
