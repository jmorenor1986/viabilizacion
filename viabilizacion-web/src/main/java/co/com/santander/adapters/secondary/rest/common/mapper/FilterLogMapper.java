package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.dto.viabilizacion.LogPayload;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;

public interface FilterLogMapper {

    LogPayload toLogRequest(ServicioEnum tipoServicio , String body, Long idRequest);

    LogPayload toLogResponse(ServicioEnum tiposervicio, String body, Long idRequest);
}
