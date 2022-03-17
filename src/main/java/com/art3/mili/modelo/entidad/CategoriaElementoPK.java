package com.art3.mili.modelo.entidad;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CategoriaElementoPK implements Serializable {
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "id_elemento")
    private Integer idElemento;
}
