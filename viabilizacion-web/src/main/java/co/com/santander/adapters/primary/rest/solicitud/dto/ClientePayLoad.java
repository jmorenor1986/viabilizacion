package co.com.santander.adapters.primary.rest.solicitud.dto;

import lombok.Data;

@Data
public class ClientePayLoad {
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String celular;
    private String correoElectronico;
    private String anoNacimiento;
    private String valorSolicitado;
    private String canalOrigen;
    private String ingresos;
    private String plazo;
    private String actividad;
    private String ciudad;

}
