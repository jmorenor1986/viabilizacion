package com.samtel.core.flow.impl;

import com.samtel.core.flow.ValidateRequest;
import com.samtel.core.response.ResponseFlow;
import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.ListaCliente;
import com.samtel.ports.secondary.solicitud.VigiaService;
import com.samtel.utils.impl.GenerateUniqueIdImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchVigiaImplTest {

	private static final String RESPUESTA_LISTAS = "<RESULTADO><REGISTRO><TIPO>ID</TIPO><DATO>98541872</DATO><LISTA>9 - LISTA PEP</LISTA><RESTRICCION>SIN DEFINICION</RESTRICCION><AMENAZA>Amenaza Baja </AMENAZA></REGISTRO></RESULTADO>";

	private ValidateRequest validateRequest;

	private GenerateUniqueIdImpl generateUniqueId;

	@Mock
	private ValidateRequest next;
	@Mock
	private VigiaService vigiaService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		validateRequest = new SearchVigiaImpl(next, vigiaService);
		generateUniqueId = new GenerateUniqueIdImpl();
	}

	@Test
	public void testSearchVigia() {
		String requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
		Cliente cliente = Cliente.builder().tipoIdentificacion("CC").numeroIdentificacion("1015").nombres("Pepito")
				.apellidos("Perez").direccion("cra 34 calle 26 - 75 sur").telefono("2365417").build();
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
		Assert.assertNotNull(result);
	}

	@Test
	public void testSearchVigiaEncontradoParcial() {
		String requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
		Cliente cliente = Mockito.mock(Cliente.class);
		Mockito.when(vigiaService.consultarListasCliente(cliente)).thenReturn(
				ListaCliente.builder().encontradoId("S").encontradoNombre("N").resultado(RESPUESTA_LISTAS).build());
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testSearchVigiaEncontradoTotal() {
		String requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
		Cliente cliente = Mockito.mock(Cliente.class);
		Mockito.when(vigiaService.consultarListasCliente(cliente)).thenReturn(
				ListaCliente.builder().encontradoId("S").encontradoNombre("S").resultado(RESPUESTA_LISTAS).build());
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testSearchVigiaNoEncontrado() {
		String requestId = generateUniqueId.generateUniqueIdStr(Long.valueOf(12));
		Cliente cliente = Mockito.mock(Cliente.class);
		Mockito.when(vigiaService.consultarListasCliente(cliente)).thenReturn(
				ListaCliente.builder().encontradoId("N").encontradoNombre("N").resultado(RESPUESTA_LISTAS).build());
		String result = validateRequest.process(cliente, requestId).orElse(ResponseFlow.DENIED).toString();
		Assert.assertNotNull(result);
	}

}
