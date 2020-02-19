package com.samtel.adapters.secondary.rest.vigia;

import com.samtel.adapters.secondary.rest.RestTemplateService;
import com.samtel.adapters.secondary.rest.common.JsonUtilities;
import com.samtel.adapters.secondary.rest.common.JsonUtilitiesImpl;
import com.samtel.adapters.secondary.rest.common.properties.ClientesProperties;
import com.samtel.adapters.secondary.rest.common.properties.VigiaProperties;
import com.samtel.adapters.secondary.rest.vigia.dto.MensajeDTO;
import com.samtel.adapters.secondary.rest.vigia.dto.VigiaDTO;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ListaCliente;
import com.samtel.ports.secondary.solicitud.VigiaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class VigiaServiceImplTest {

    private VigiaService vigiaService;
    private ClientesProperties properties;
    @Mock
    private RestTemplateService restTemplateService;
    private JsonUtilities jsonUtilities;
    private VigiaProperties vigiaProperties;

    @Before
    public void setUp() {
        jsonUtilities = new JsonUtilitiesImpl();
        MockitoAnnotations.initMocks(this);
        vigiaProperties = VigiaProperties.builder()
                .uriVigia("http://www.mocky.io/v2/5e45638a3000002848614baa")
                .codigoEjecucion("null")
                .origen("PRODUCCIÓN")
                .porcentaje("76")
                .build();
        properties = new ClientesProperties();
        properties.setVigiaProperties(vigiaProperties);
        vigiaService = new VigiaServiceImpl(restTemplateService, properties, jsonUtilities);
    }

    @Test
    public void testConsultarListasCliente() {
        Cliente datosBasicosCliente = Cliente
                .builder()
                .apellidos("QUINTERO BRAVO")
                .nombres("MONICA")
                .numeroIdentificacion("38567097")
                .build();
        MensajeDTO mensajeDTO = MensajeDTO
                .builder()
                .nombre("QUINTERO BRAVO MONICA")
                .numeroIdentificacion("38567097")
                .origen(vigiaProperties.getOrigen())
                .porcentaje(vigiaProperties.getPorcentaje())
                .build();
        VigiaDTO vigiaDTO = VigiaDTO
                .builder()
                .codigoEjecucion(vigiaProperties.getCodigoEjecucion())
                .mensaje(mensajeDTO)
                .build();
        Mockito.when(restTemplateService.getWithOutParams(vigiaProperties.getUriVigia(), vigiaDTO, Optional.of("123"))).thenReturn(Optional.of(MockResponseServiceVigia.response));
        ListaCliente result = vigiaService.consultarListasCliente(datosBasicosCliente, "123");
        Assert.assertNotNull(result);
    }
}
