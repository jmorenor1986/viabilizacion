package com.samtel.validation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NamedQuery(name = "Ciudad.buscarPorCodigoONombre", query = "FROM Ciudad where codigo  = ?1 or nombre = ?1")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigo;
    private String nombre;
    private String estado;
}
