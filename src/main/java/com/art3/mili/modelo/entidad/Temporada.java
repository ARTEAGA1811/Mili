package com.art3.mili.modelo.entidad;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "temporada")
@Data
public class Temporada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temporada")
    private Integer idTemporada;

    @Column(name = "nombre_temporada", length = 50, nullable = false)
    private String nombreTemporada;

    //FK
    @Column(name = "id_elemento", nullable = false)
    private Integer idElemento;

    @ManyToOne
    @JoinColumn(name="id_elemento", insertable=false, updatable=false)
    private Elemento elemento;
}
