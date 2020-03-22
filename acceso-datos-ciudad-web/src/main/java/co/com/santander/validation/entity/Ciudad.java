package co.com.santander.validation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQuery(name = "Ciudad.buscarPorCodigoONombre", query = "FROM Ciudad where ( lower(codigo) = lower(?1) or lower(nombre) = lower(?1) ) and estado = 'ACTIVO'")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciudad_generator")
    @SequenceGenerator(name = "ciudad_generator", sequenceName = "ciudad_seq", allocationSize = 1)
    private Long id;
    private String codigo;
    private String nombre;
    private String estado;
}
