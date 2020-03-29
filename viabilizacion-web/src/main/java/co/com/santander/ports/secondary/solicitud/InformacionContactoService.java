package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

import java.util.Arrays;
import java.util.Optional;

public interface InformacionContactoService {

    Optional<ResponseInformacionContacto> consultarDatosUsuario(Cliente cliente, InformacionContacto informacionContacto, Long idRequest);

    JsonUtilities getJsonUtilities();

    default ResponseInformacionContacto buscarRespuestaReconocer(String objeto){
        return ResponseInformacionContacto.builder()
                .numeroCelular(Arrays.asList(new String(getJsonUtilities().getPropertyObjectWithKey("reporte.celulares", "celular", objeto))))
                .numerosTelefono(Arrays.asList(new String(getJsonUtilities().getPropertyObjectWithKey("reporte.telefonos", "telefono", objeto))))
                .direcciones(getJsonUtilities().getValuesForGivenKey("reporte", "direcciones", "dato", objeto))
                .correoElectronico(getJsonUtilities().getValuesForGivenKey("reporte", "emails", "dato", objeto))
                .build();
    }



    default String extractTokenReconocer(String response){
        String respuestaServicio = response;
        //Eliminar caracteres extranios
        Integer inicio = respuestaServicio.indexOf("{");
        Integer fin = respuestaServicio.indexOf("}");
        String json = respuestaServicio.substring(inicio,fin);
        //Extraigo el valor del token
        inicio= json.indexOf("access_token=");
        fin = json.indexOf("scope=");
        String token = json.substring(inicio,fin);
        //Quitamos La propiedad
        inicio= token.indexOf("=");
        token = token.substring(inicio+1,token.length() -2);
        return token;
    }
}
