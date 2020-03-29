package co.com.santander.adapters.secondary.rest.common.mapper.impl;

import co.com.santander.adapters.secondary.rest.common.mapper.RestRequestMapper;
import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.dictum.Dictum;
import co.com.santander.dto.dictum.ParametrosDTO;
import co.com.santander.dto.dictum.RequestDictumDTO;
import co.com.santander.dto.generic.GeneralPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictumMapperImpl extends RestRequestMapper<RequestDictumDTO, Dictum> {
    @Value("${dictum.parametros.clave}")
    private String clave;
    @Value("${dictum.parametros.producto}")
    private String producto;

    @Override
    public GeneralPayload<RequestDictumDTO> dtoToRequest(Dictum request, Cliente cliente) {
        GeneralPayload<RequestDictumDTO> result = new GeneralPayload<>();
        result.setRequestHeader(setHeader(cliente.getRequestHeader()));
        result.setRequestBody(RequestDictumDTO.builder()
                //TODO ¿Que se debe poner en clave? = se coloca lo mismo que en el ejemplo 06BRZ
                .clave(clave)
                .parametros(generateParams(cliente))
                //TODO ¿En este campo se debe hacer un split y tomar el primero o colocar el campo tal cual el digitado?
                .primerApellido(cliente.getApellidos())
                //TODO ¿Que se debe poner en producto? = se va ha colocar el mismo que en el ejemplo 64
                .producto(producto)
                //TODO ¿Si se debe colocar el numero de identificacion en este campo?
                .usuario(cliente.getNumeroIdentificacion())
                .build());
        return result;
    }

    private List<ParametrosDTO> generateParams(Cliente cliente){
        List<ParametrosDTO> parametrosList = new ArrayList<>();
        //Genero el anio de nacimiento
        parametrosList.add(ParametrosDTO.builder()
                .tipo("T")
                .nombre("nombre")
                .valor(cliente.getNombres())
                .build());
        //Genero el valor solicitado
        parametrosList.add(ParametrosDTO.builder()
                .tipo("T")
                .nombre("VALOR_SOLICITADO")
                .valor(cliente.getValorSolicitado())
                .build());
        //Genero ingresos
        parametrosList.add(ParametrosDTO.builder()
                .tipo("T")
                .nombre("INGRESOS")
                .valor(cliente.getIngresos())
                .build());
        //Genero plazo
        parametrosList.add(ParametrosDTO.builder()
                .tipo("T")
                .nombre("PLAZO")
                .valor(cliente.getPlazo())
                .build());
        //TODO ¿De donde saco la actividad? = El valor se encuentra quemado
        //Genero plazo
        parametrosList.add(ParametrosDTO.builder()
                .tipo("T")
                .nombre("ACTIVIDAD")
                .valor(cliente.getActividad())
                .build());
        return parametrosList;
    }
}
