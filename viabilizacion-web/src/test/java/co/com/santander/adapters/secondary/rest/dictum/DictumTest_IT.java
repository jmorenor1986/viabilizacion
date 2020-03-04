package co.com.santander.adapters.secondary.rest.dictum;

import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.secondary.rest.RestTemplateService;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.core.domain.solicitud.dictum.Parametros;
import co.com.santander.core.domain.solicitud.dictum.RequestBody;
import co.com.santander.core.domain.solicitud.dictum.RequestDictum;
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
    private RestTemplateService restTemplateService;
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
        RequestBody requestBody = new RequestBody();
        requestBody.setClave("06BRZ");
        requestBody.setPrimerApellido("BECERRA");
        requestBody.setProducto("64");
        requestBody.setUsuario("91518562");
        List<Parametros> parametros = new ArrayList<>();
        Parametros parametro = new Parametros();
        parametro.setNombre("ANIO_NACIMIENTO");
        parametro.setTipo("T");
        parametro.setValor("1980");
        parametros.add(parametro);
        requestBody.setParametros(parametros);
        RequestDictum request = RequestDictum.builder()
                .requestBody(requestBody)
                .requestHeader(requestHeader)
                .build();
        Optional<String> result = restTemplateService.postWithOutParams(properties.getUriDictum(), request, Optional.of(new HashMap<>()));
        Assert.assertNotNull(result);
    }

}
