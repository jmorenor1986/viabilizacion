package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

import java.util.List;
import java.util.Optional;

public interface UbicaService {

    Optional<ResponseInformacionContacto> consultarInformacionContacto(Cliente cliente, InformacionContacto informacionContacto, Long idRequest);

    JsonUtilities getJsonUtilities();

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
}
