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
    @Value("${vigia.url}")
    private String VIGIA;

    @Override
    public Optional<String> getUrlFrom(ServicioEnum servicio) {
        if( ServicioEnum.VALIDATE_CITY.equals(servicio) ){
            return Optional.of( VALIDAR_CIUDAD );
        }else if(ServicioEnum.VIGIA.equals(servicio)){
            return Optional.of( VIGIA );
        }
        return Optional.empty();
    }

}
