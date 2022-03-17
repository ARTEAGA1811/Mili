package com.art3.mili.modelo.entidad;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pelicula")
@Data
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(name = "nombre_pelicula", length = 50, nullable = false)
    private String nombrePelicula;

    //FK
    @Column(name = "id_elemento", nullable = false)
    private Integer idElemento;

    @ManyToOne
    @JoinColumn(name = "id_elemento", insertable = false, updatable = false)
    private Elemento elemento;
}
