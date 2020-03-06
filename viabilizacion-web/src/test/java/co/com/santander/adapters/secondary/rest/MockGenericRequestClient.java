package co.com.santander.adapters.secondary.rest;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.RequestHeader;

public class MockGenericRequestClient {

    public static Cliente setClient() {
        return Cliente.builder()
                .requestHeader(new MockGenericRequestClient().setRequestHeader())
                .apellidos("MONTERO DIAZ")
                .nombres("MIGUEL ANFEL")
                .numeroIdentificacion("1110775")
                .direccion("cra cra cra")
                .telefono("123456789")
                .tipoIdentificacion("1")
                .actividad("Activiad")
                .anoNacimiento("1990")
                .celular("30030033000")
                .correoElectronico("pepito.perez@sanitas.com.co")
                .ingresos("0")
                .plazo("1")
                .valorSolicitado("1000000")
                .ciudad("BOGOTA")
                .build();
    }

    private RequestHeader setRequestHeader() {
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setCodAliado("001");
        requestHeader.setUsuarioAliado("pepito.perez@sanitas.com.co");
        requestHeader.setSesionId("1234");
        requestHeader.setIpOrigen("0.0.0.0");
        requestHeader.setNumeroSolicitudCredito("000012");
        requestHeader.setTipoIdentificacion("1");
        requestHeader.setIdentificacion("1110775");
        return requestHeader;
    }


}
