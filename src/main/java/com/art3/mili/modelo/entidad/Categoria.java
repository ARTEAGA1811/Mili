package com.art3.mili.modelo.entidad;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre_categoria", length = 50, nullable = false)
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<CategoriaElemento> elementos;
}
