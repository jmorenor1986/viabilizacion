package co.com.santander.bizagi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {
    private String Tipodeidentificacion;
    private String NumeroIdentificacion;
    private String Apellido1;
    private String Apellido2;
    private String Nombre1;
    private String Nombre2;

    private String fechaNacimiento;
    private String telefonoResidencia;
    private String celularPersonal;
    private String correoPersonal;
    private String ingresosMensuales;
    private String valorSolicitado;
}
