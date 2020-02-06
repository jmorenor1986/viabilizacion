package com.samtel.validation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQuery(name = "Ciudad.buscarPorCodigoONombre", query = "FROM Ciudad where codigo  = ?1 or nombre = ?1 where estado = 'ACTIVO'")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigo;
    private String nombre;
    private String estado;
}
