package co.com.santander.adapters.secondary.rest.access.impl;

import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.clients.*;
import co.com.santander.clients.viabilizacion.EmailSenderClient;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import io.vavr.control.Option;
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
    private final EmailSenderClient emailSenderClient;
    private final JsonUtilities jsonUtilities;

    @Autowired
    public RestServiceImpl(JsonUtilities jsonUtilities, ValidateCityClient validateCityClient
            , VigiaClient vigiaClient
            , DictumClient dictumClient
            , ReconocerClient reconocerClient
            , UbicaClient ubicaClient
            , BizagiClient bizagiClient
            , EmailSenderClient emailSenderClient) {
        this.jsonUtilities = jsonUtilities;
        this.validateCityClient = validateCityClient;
        this.vigiaClient = vigiaClient;
        this.dictumClient = dictumClient;
        this.reconocerClient = reconocerClient;
        this.ubicaClient = ubicaClient;
        this.bizagiClient = bizagiClient;
        this.emailSenderClient = emailSenderClient;
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
                String rta_vigia = vigiaClient.consultaVigia(request);
                return Optional.of(jsonUtilities.getGeneralResponse(rta_vigia));
            case DICTUM:
                String rta = dictumClient.consultarHC2(request);
                return Optional.of(jsonUtilities.getGeneralResponse(rta));
            case TOKEN_RECONOCER:
                String rtaToken = reconocerClient.obtenerToken(request);
                return Optional.of(jsonUtilities.getGeneralResponse(rtaToken));
            case RECONOCER:
                String rtaReconocer = reconocerClient.firmaElectronica(request);
                return Optional.of(jsonUtilities.getGeneralResponse(rtaReconocer));
            case UBICA:
                String rta_ubica = ubicaClient.ubicaPostService(request);
                return Optional.of(jsonUtilities.getGeneralResponse(rta_ubica));
            case BIZAGI:
                return Optional.of(bizagiClient.consultarHC2(request));
            case EMAIL_SENDER:
                String rta_email = emailSenderClient.sendMail(request);
                return Optional.of(jsonUtilities.getGeneralResponse(rta_email));
            default:
                return Optional.empty();
        }
    }
}
