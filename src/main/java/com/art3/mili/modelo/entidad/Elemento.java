package com.art3.mili.modelo.entidad;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "elemento")
@Data
public class Elemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_elemento")
    private Integer idElemento;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double puntuacion;

    @Column(length = 20, nullable = false)
    private String estado;

    @Column(name = "es_anime", nullable = false)
    private Boolean esAnime;

    //FK
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    ////
    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "elemento")
    List<Temporada> temporadas;

    @OneToMany(mappedBy = "elemento")
    List<Pelicula> peliculas;

    @OneToMany(mappedBy = "elemento")
    List<CategoriaElemento> categorias;

}
