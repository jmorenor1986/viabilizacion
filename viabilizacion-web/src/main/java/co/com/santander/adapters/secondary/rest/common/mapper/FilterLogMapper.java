package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.controller.payload.LogPayload;

public interface FilterLogMapper {

    LogPayload toLogRequest(ServicioEnum tipoServicio , String body, Long idRequest);

    LogPayload toLogResponse(ServicioEnum tiposervicio, String body, Long idRequest);
}
