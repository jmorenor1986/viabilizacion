package co.com.santander.adapters.secondary.rest.access.impl;

import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.clients.*;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.persistencia.constants.ServicioEnum;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("restServiceImpl")
public class RestServiceImpl implements RestService {

    private final ValidateCityClient validateCityClient;
    private final VigiaClient vigiaClient;
    private final DictumClient dictumClient;
    private final ReconocerClient reconocerClient;
    private final UbicaClient ubicaClient;
    private final BizagiClient bizagiClient;

    @Autowired
    public RestServiceImpl(ValidateCityClient validateCityClient
            , VigiaClient vigiaClient
            , DictumClient dictumClient
            , ReconocerClient reconocerClient
            , UbicaClient ubicaClient
            , BizagiClient bizagiClient) {
        this.validateCityClient = validateCityClient;
        this.vigiaClient = vigiaClient;
        this.dictumClient = dictumClient;
        this.reconocerClient = reconocerClient;
        this.ubicaClient = ubicaClient;
        this.bizagiClient = bizagiClient;
    }

    @Override
    public Optional<ResponseDto> callService(GeneralPayload request, ServicioEnum servicio, Optional<Map<String, String>> cache) {
        return callEspecificService(request, servicio);
    }

    public Optional<ResponseDto> callEspecificService(GeneralPayload request, ServicioEnum servicio) {
        switch (servicio) {
            case VALIDATE_CITY:
                return Optional.of(validateCityClient.consultaCity(request));
            case VIGIA:
                return Optional.of(vigiaClient.consultaVigia(request));
            case DICTUM:
                return Optional.of(dictumClient.consultarHC2(request));
            case TOKEN_RECONOCER:
                return Optional.of(reconocerClient.obtenerToken(request));
            case RECONOCER:
                return Optional.of(reconocerClient.firmaElectronica(request));
            case UBICA:
                return Optional.of(ubicaClient.ubicaPostService(request));
            case BIZAGI:
                return Optional.of(bizagiClient.consultarHC2(request));
            default:
                return Optional.empty();
        }
    }
}
