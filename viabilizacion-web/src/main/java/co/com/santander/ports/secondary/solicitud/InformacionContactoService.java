package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;

import java.util.Arrays;
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
}
