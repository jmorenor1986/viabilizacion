package co.com.santander.core.services.solicitud;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.dto.RequestHeader;
import co.com.santander.adapters.primary.rest.solicitud.dto.ClientePayLoad;
import co.com.santander.ports.primary.solicitud.MapperCliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperClienteImplTest {

    private MapperCliente mapperCliente;
    private GeneralPayload<ClientePayLoad> payload;

    @Before
    public void setUp(){
        this.mapperCliente = new MapperClienteImpl(new ModelMapper());
    }

    @Test
    public void testObject() {
        ClientePayLoad cliente = new ClientePayLoad();
        cliente.setTipoIdentificacion("1");
        cliente.setNumeroIdentificacion("1030585312");
        //Creo el objeto necesario para probar
        payload = GeneralPayload.<ClientePayLoad>builder()
                .requestHeader(RequestHeader.builder()
                        .codAliado("001")
                        .usuarioAliado("pepito.perez@sanitas.com.co")
                        .sesionId("fb2e77d.47a0479900504cb3ab4a1f626d174d2d")
                        .ipOrigen("127.0.0.1")
                        .numeroSolicitudCredito("000012")
                        .tipoIdentificacion("1")
                        .identificacion("91518562")
                        .build())
                .requestBody(cliente)
                .build();
        Assert.assertNotNull(mapperCliente.fromGeneralPayLoad(payload));
    }
}
