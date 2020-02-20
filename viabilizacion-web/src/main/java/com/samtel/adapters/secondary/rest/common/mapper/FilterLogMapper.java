package com.samtel.adapters.secondary.rest.common.mapper;

import com.samtel.domain.repository.entity.FlowOperationEnum;
import com.samtel.domain.repository.entity.LogEntity;
import org.springframework.http.HttpRequest;

public interface FilterLogMapper {

    LogEntity toLogRequest(HttpRequest request , String body, String idRequest);

    LogEntity toLogResponse(HttpRequest request, FlowOperationEnum tipoOperation,  String idRequest);
}
