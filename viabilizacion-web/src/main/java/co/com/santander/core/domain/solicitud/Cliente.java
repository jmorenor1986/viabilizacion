package co.com.santander.core.domain.solicitud;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String ciudad;
    private String canalOrigen;
    //Dato Vigia en el caso de que sea TRUE, quiere decir que fue encontrado en Vigia
    private Boolean vigia;
    //Dato relevante de dictum
    private String decision;
    //Si encuentra alguno de los datos sera true de lo contrario sera false
    private Boolean validaReconocer;
    private Boolean validaUbica;

    private RequestHeader requestHeader;
    
}
