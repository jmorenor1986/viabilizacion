package co.com.santander.ports.secondary.solicitud;

import co.com.santander.adapters.secondary.rest.dictum.common.DecisionDictum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.core.errors.XmlParsingException;

import java.util.Objects;
import java.util.Optional;

public interface DictumService {
    //Metodo principal de la interfaz
    Optional<String> consultarSolicitudDictum(Cliente cliente, Dictum dictum, Long idRequest);

    public static final String ERROR_RESPONSE_NULL = "ERROR AL OBTENER LA RESPUESTA";

    default Optional<String> consultarDecisionDictum(String responseDictumDTO) {
        if (Objects.nonNull(responseDictumDTO)) {
            return buscarRespuesta(responseDictumDTO);
        }
        throw new XmlParsingException(ERROR_RESPONSE_NULL);
    }

    default Optional<String> buscarRespuesta(String xml) {
        if (xml.contains(DecisionDictum.PREAPROBADO_CON_DOCUMENTOS))
            return Optional.of(DecisionDictum.PREAPROBADO_CON_DOCUMENTOS);
        if (xml.contains(DecisionDictum.PREAPROBADO_SIN_DOCUMENTOS))
            return Optional.of(DecisionDictum.PREAPROBADO_SIN_DOCUMENTOS);
        if (xml.contains(DecisionDictum.APROBADO))
            return Optional.of(DecisionDictum.APROBADO);
        if (xml.contains(DecisionDictum.ERROR_EN_PROCESO))
            return Optional.of(DecisionDictum.ERROR_EN_PROCESO);
        if (xml.contains(DecisionDictum.NEGADO))
            return Optional.of(DecisionDictum.NEGADO);
        return Optional.of(DecisionDictum.SIN_RESPUESTA);
    }

}
