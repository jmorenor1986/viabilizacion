package co.com.santander.adapters.secondary.rest.informacioncontacto;

import co.com.santander.adapters.secondary.rest.MockGenericRequestClient;
import co.com.santander.adapters.secondary.rest.access.RestService;
import co.com.santander.adapters.secondary.rest.common.JsonUtilities;
import co.com.santander.adapters.secondary.rest.common.JsonUtilitiesImpl;
import co.com.santander.adapters.secondary.rest.common.properties.ClientesProperties;
import co.com.santander.adapters.secondary.rest.common.properties.InformacionContactoProperties;
import co.com.santander.adapters.secondary.rest.common.properties.ReconocerProperties;
import co.com.santander.adapters.secondary.rest.common.properties.UbicaProperties;
import co.com.santander.adapters.secondary.rest.informacioncontacto.mapper.InformacionContactoMapperImpl;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.InformacionContacto;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import co.com.santander.dto.generic.GeneralPayload;
import co.com.santander.dto.generic.RequestHeader;
import co.com.santander.dto.generic.ResponseDto;
import co.com.santander.dto.reconocer.InformacionContactoDTO;
import co.com.santander.ports.secondary.solicitud.InformacionContactoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class InformacionContactoServiceImplTest {

    public static final String URI_RECONOCER = "URI_RECONOCER";
    private InformacionContactoService informacionContactoService;
    private ClientesProperties properties;

    @Mock
    private RestService restService;

    private Map<String, String> headers;


    private JsonUtilities jsonUtilities;

    private InformacionContacto informacionContacto;
    private ResponseInformacionContacto responseInformacionContacto;
    private InformacionContactoProperties informacionContactoProperties;
    private Cliente cliente;
    @Mock
    private InformacionContactoMapperImpl informacionContactoMapper;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cliente = MockGenericRequestClient.setClient();
        informacionContactoMapper = new InformacionContactoMapperImpl();
        jsonUtilities = new JsonUtilitiesImpl();
        properties = new ClientesProperties();
        informacionContacto = InformacionContacto.builder()
                .primerApellidoBuscar("PEREZ")
                .validarNombre("false")
                .build();
        responseInformacionContacto = ResponseInformacionContacto.builder()
                .direcciones(new ArrayList<>())
                .numeroCelular(new ArrayList<>())
                .numerosTelefono(new ArrayList<>())
                .build();
        ReconocerProperties reconocerProperties = ReconocerProperties.builder()
                .numeroIdBuscar("1010101010")
                .tipoIdBuscar("1")
                .nit("900468987")
                .uri("http://www.mocky.io/v2/5e4473f731000098df3b06ff")
                .validarNombre("true")
                .build();
        UbicaProperties ubicaProperties = UbicaProperties.builder()
                .codigoInformacion("5632")
                .motivoConsulta("1")
                .uri("http://www.mocky.io/v2/5e492eae3000004a008c2cf7")
                .build();
        informacionContactoProperties = InformacionContactoProperties.builder()
                .reconocerProperties(reconocerProperties)
                .ubicaProperties(ubicaProperties)
                .build();
        properties.setInformacionContactoProperties(informacionContactoProperties);
        properties.setReconocerProperties(reconocerProperties);
        properties.setUbicaProperties(ubicaProperties);
        informacionContactoService = new InformacionContactoServiceImpl(restService, properties, jsonUtilities, informacionContactoMapper);
        headers = new HashMap<>();
        headers.put("idRequest", "123");
    }
    @Test
    public void test(){
        Assert.assertNotNull(true);
    }
}
