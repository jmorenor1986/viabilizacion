package co.com.santander.adapters.secondary.rest.bizagi;

import co.com.santander.adapters.secondary.rest.ServiceRestAbs;
import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.bizagi.mapper.BizagiMapperImpl;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.core.common.ServicioEnum;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.dto.bizagi.BizagiDTO;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.ports.secondary.solicitud.BizagiService;
import co.com.santander.utils.CreateHeadersMap;
import co.com.santander.utils.dto.HeaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class BizagiServiceImpl extends ServiceRestAbs implements BizagiService {
    private final RestService restService;
    private final ClientesProperties properties;
    private final BizagiMapperImpl bizagiMapper;

    @Autowired
    public BizagiServiceImpl(@Qualifier("restServiceImpl") RestService restService, ClientesProperties properties, JsonUtilities jsonUtilities, BizagiMapperImpl bizagiMapper, BizagiMapperImpl bizagiMapper1) {
        this.restService = restService;
        this.properties = properties;
        this.bizagiMapper = bizagiMapper1;
        this.jsonUtilities = jsonUtilities;
    }

    @Override
    public Optional<String> createCaseBizagi(Cliente cliente, Long idRequest) {
        GeneralPayload<BizagiDTO> request = bizagiMapper.dtoToRequest(null, cliente);
        Optional<Map<String, String>> headersMap  = CreateHeadersMap.generateMap(HeaderDto.builder()
                .key("idRequest")
                .value(idRequest.toString())
                .build());
        Optional<ResponseDto> result = restService.callService(request, ServicioEnum.BIZAGI, headersMap);
        return Optional.empty();
    }


}
