package com.samtel.core;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.domain.solicitud.RequestData;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("searchReconocer")
public class SearchReconocerImpl implements ValidateRequest {

    private static final Logger log= LoggerFactory.getLogger(SearchReconocerImpl.class);

    @Getter @Setter
    private RequestData data;

    public SearchReconocerImpl() {
    }

    @Override
    public Optional<Boolean> process(RequestData data) {
        setData(data);
        log.info("Llego al final del proceso");
        return Optional.of(Boolean.TRUE);
    }
}
