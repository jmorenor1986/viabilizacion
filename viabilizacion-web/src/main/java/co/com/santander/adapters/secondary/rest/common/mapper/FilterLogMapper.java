package co.com.santander.adapters.secondary.rest.common.mapper;

import co.com.santander.core.domain.log.LogGeneral;
import co.com.santander.adapters.secondary.database.santander.constants.FlowOperationEnum;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;

public interface FilterLogMapper {

    LogGeneral toLogRequest(HttpRequest request , String body, Long idRequest);

    LogGeneral toLogResponse(ClientHttpResponse response, FlowOperationEnum tipoOperation, Long idRequest, String body, String url);
}
