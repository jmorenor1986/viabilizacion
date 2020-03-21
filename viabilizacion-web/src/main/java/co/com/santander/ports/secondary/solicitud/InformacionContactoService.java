package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface InformacionContactoService {
    Optional<ResponseInformacionContacto> consultarDatosUsuario(Cliente cliente, InformacionContacto informacionContacto, Long idRequest);

    Optional<ResponseInformacionContacto> consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest);

    JsonUtilities getJsonUtilities();

    default ResponseInformacionContacto buscarRespuestaReconocer(String objeto){
        return ResponseInformacionContacto.builder()
                .numeroCelular(Arrays.asList(new String(getJsonUtilities().getPropertyObjectWithKey("reporte.celulares", "celular", objeto))))
                .numerosTelefono(Arrays.asList(new String(getJsonUtilities().getPropertyObjectWithKey("reporte.telefonos", "telefono", objeto))))
                .direcciones(getJsonUtilities().getValuesForGivenKey("reporte", "direcciones", "dato", objeto))
                .correoElectronico(getJsonUtilities().getValuesForGivenKey("reporte", "emails", "dato", objeto))
                .build();
    }

    default Optional<ResponseInformacionContacto> buscarRespuestaUbica(String json){
        if(json.isEmpty())
            return Optional.empty();
        String objetoUbicacion = getJsonUtilities().getObjectWithKey("CIFIN.Tercero.UbicaPlusCifin", json);

        List<String> correos = getJsonUtilities().getValuesForGivenKey("Mails", "Mail","Correo", objetoUbicacion);
        List<String> celulares = getJsonUtilities().getValuesForGivenKey("Celulares", "Celular","Celular", objetoUbicacion);
        List<String> telefonos = getJsonUtilities().getValuesForGivenKey("Telefonos", "Telefono","Telefono", objetoUbicacion);

        return Optional.of( ResponseInformacionContacto.builder()
                .correoElectronico(correos)
                .numeroCelular(celulares)
                .numerosTelefono(telefonos)
                .build() );
    }

    default String extractTokenReconocer(String response){
        ResponseDto responseDto = getJsonUtilities().getGeneralResponse(response);
        String respuestaServicio = responseDto.getRespuestaServicio();
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
