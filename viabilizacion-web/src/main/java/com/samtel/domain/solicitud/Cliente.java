package com.samtel.domain.solicitud;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cliente {
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String celular;
    private String correoElectronico;
    private String anoNacimiento;
    private String valorSolicitado;
    private String ingresos;
    private String plazo;
    private String actividad;
}
