package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.adapters.secondary.rest.accesodatos.payload.LogPayload;
import co.com.santander.core.common.ServicioEnum;

public interface FilterLogMapper {

    LogPayload toLogRequest(ServicioEnum tipoServicio , String body, Long idRequest);

    LogPayload toLogResponse(ServicioEnum tiposervicio, String body, Long idRequest);
}
