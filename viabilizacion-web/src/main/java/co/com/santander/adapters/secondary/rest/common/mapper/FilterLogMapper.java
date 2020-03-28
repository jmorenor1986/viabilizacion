package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.service.dto.LogPayload;

public interface FilterLogMapper {

    LogPayload toLogRequest(String uri , String body, Long idRequest);

    LogPayload toLogResponse(FlowOperationEnum tipoOperation, Long idRequest, String body, String url);
}
