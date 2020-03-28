package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.persistencia.constants.FlowOperationEnum;
import co.com.santander.persistencia.constants.ServicioEnum;
import co.com.santander.persistencia.service.dto.LogPayload;

public interface FilterLogMapper {

    LogPayload toLogRequest(ServicioEnum tipoServicio , String body, Long idRequest);

    LogPayload toLogResponse(ServicioEnum tiposervicio, String body, Long idRequest);
}
