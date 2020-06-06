package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.dto.dictum.ParametrosDTO;
import co.com.santander.dto.dictum.RequestDictumDTO;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.RequestHeader;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.viabilizacion.constants.ServicioEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DictumTest_IT {
    @Autowired
    private RestService restService;
    @Autowired
    private ClientesProperties properties;

    @Test
    public void testConsumeServieDictum() {
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setCodAliado("001");
        requestHeader.setUsuarioAliado("pepito.perez@sanitas.com.co");
        requestHeader.setIdentificacion("91518562");
        requestHeader.setTipoIdentificacion("1");
        requestHeader.setIpOrigen("127.0.0.1");
        requestHeader.setNumeroSolicitudCredito("00012");
        requestHeader.setSesionId("fb2e77d.47a0479900504cb3ab4a1f626d174d2d");
        List<ParametrosDTO> parametros = new ArrayList<>();
        ParametrosDTO parametro = new ParametrosDTO();
        parametro.setNombre("ANIO_NACIMIENTO");
        parametro.setTipo("T");
        parametro.setValor("1980");
        parametros.add(parametro);
        RequestDictumDTO requestBody = RequestDictumDTO.builder()
                .clave("06BRZ")
                .usuario("91518562")
                .producto("64")
                .primerApellido("BECERRA")
                .parametros(parametros)
                .build();
        requestBody.setParametros(parametros);
        GeneralPayload<RequestDictumDTO> request = new GeneralPayload<>();
        request.setRequestBody(requestBody);
        request.setRequestHeader(requestHeader);
        Optional<ResponseDto> result = restService.callService(request, ServicioEnum.DICTUM, Optional.of(new HashMap<>()));
        Assert.assertNotNull(result);
    }

}
