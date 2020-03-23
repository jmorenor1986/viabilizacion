package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import co.com.santander.core.domain.log.LogGeneral;

public interface FilterLogMapper {

    LogGeneral toLogRequest(String uri , String body, Long idRequest);

    LogGeneral toLogResponse(FlowOperationEnum tipoOperation, Long idRequest, String body, String url);
}
