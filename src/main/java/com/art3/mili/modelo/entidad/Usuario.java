package com.art3.mili.modelo.entidad;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario", unique = true, length =11)
    private Integer idUsuario;


    @Column(name="nombre_usuario", length =30, nullable = false)
    private String nombreUsuario;

    @Column(length = 30, nullable = false)
    private String clave;

    @OneToMany(mappedBy = "usuario")
    List<Elemento> elementos;
}
