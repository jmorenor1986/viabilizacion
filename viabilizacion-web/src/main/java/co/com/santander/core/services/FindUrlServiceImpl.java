package co.com.santander.core.services;

import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import co.com.santander.ports.primary.FindUrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUrlServiceImpl implements FindUrlService {

    @Value("${validarciudad.url}")
    private String VALIDAR_CIUDAD;
    @Value("${validarciudad.metodo.consultar-ciudad}")
    private String VALIDAR_CIUDAD_MT_CIUDAD;

    @Value("${vigia.url}")
    private String VIGIA;
    @Value("${vigia.metodo.consultar-vigia}")
    private String VIGIA_MT_VIGIA;

    @Value("${dictum.url}")
    private String DICTUM;
    @Value("${dictum.metodo.consultar-dictum}")
    private String DICTUM_MT_DICTUM;

    @Value("${ubica.url}")
    private String UBICA;
    @Value("${ubica.metodo.consultar-ubica}")
    private String UBICA_MT_UBICA;

    @Value("${reconocer.url}")
    private String RECONOCER;
    @Value("${reconocer.metodo.consulta-token}")
    private String RECONOCER_MT_TOKEN;
    @Value("${reconocer.metodo.consulta-reconocer}")
    private String RECONOCER_MT_CONSULTA;;

    @Value("${bizagi.url}")
    private String BIZAGI;
    @Value("${bizagi.metodo.create-case}")
    private String BIZAGI_MT_CREATE_CASE;

    @Value("${viabilizacion.email.url}")
    private String EMAIL_SENDER;
    @Value("${viabilizacion.email.metodo}")
    private String EMAIL_SENDER_SENDMAIL;


    @Override
    public Optional<String> getUrlFrom(ServicioEnum servicio) {
        if( ServicioEnum.VALIDATE_CITY.equals(servicio) ){
            return Optional.of( VALIDAR_CIUDAD.concat(VALIDAR_CIUDAD_MT_CIUDAD) );
        }else if(ServicioEnum.VIGIA.equals(servicio)){
            return Optional.of( VIGIA.concat( VIGIA_MT_VIGIA ) );
        }else if(ServicioEnum.DICTUM.equals(servicio)){
            return Optional.of( DICTUM.concat(DICTUM_MT_DICTUM));
        }else if(ServicioEnum.UBICA.equals(servicio)) {
            return Optional.of(UBICA.concat(UBICA_MT_UBICA));
        }else if(ServicioEnum.RECONOCER.equals(servicio)) {
            return Optional.of(RECONOCER.concat(RECONOCER_MT_CONSULTA));
        }else if(ServicioEnum.TOKEN_RECONOCER.equals(servicio)) {
            return Optional.of(RECONOCER.concat(RECONOCER_MT_TOKEN));
        }else if(ServicioEnum.BIZAGI.equals(servicio)) {
            return Optional.of(BIZAGI.concat(BIZAGI_MT_CREATE_CASE));
        }else if(ServicioEnum.EMAIL_SENDER.equals(servicio)){
            return Optional.of(EMAIL_SENDER.concat(EMAIL_SENDER_SENDMAIL));
        }
        return Optional.empty();
    }

}
