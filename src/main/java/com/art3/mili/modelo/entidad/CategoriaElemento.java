package com.art3.mili.modelo.entidad;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "categoriaelemento")
@Data
public class CategoriaElemento {

    @EmbeddedId
    private CategoriaElementoPK id;


    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_elemento", insertable = false, updatable = false)
    private Elemento elemento;
}
