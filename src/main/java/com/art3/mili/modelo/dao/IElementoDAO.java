package com.art3.mili.modelo.dao;

import com.art3.mili.modelo.entidad.Elemento;
import org.springframework.data.repository.CrudRepository;

public interface IElementoDAO extends CrudRepository<Elemento,Integer> {
}
