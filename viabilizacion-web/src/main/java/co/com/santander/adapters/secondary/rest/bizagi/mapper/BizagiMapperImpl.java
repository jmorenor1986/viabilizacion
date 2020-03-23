package co.com.santander.adapters.secondary.rest.bizagi.mapper;

import co.com.santander.adapters.dto.GeneralPayload;
import co.com.santander.adapters.secondary.rest.bizagi.dto.BizagiDTO;
import co.com.santander.adapters.secondary.rest.common.mapper.RestRequestMapper;
import co.com.santander.core.domain.solicitud.Cliente;
import org.springframework.stereotype.Service;

@Service
public class BizagiMapperImpl extends RestRequestMapper<BizagiDTO, BizagiDTO> {

    @Override
    public GeneralPayload<BizagiDTO> dtoToRequest(BizagiDTO request, Cliente cliente) {
        GeneralPayload<BizagiDTO> result = GeneralPayload.<BizagiDTO>builder()
                .requestHeader(setHeader(cliente.getRequestHeader()))
                .requestBody(BizagiDTO.builder()
                        .numeroIdentificacion(cliente.getNumeroIdentificacion())
                        .tipodeidentificacion(identifyTypeId(cliente.getTipoIdentificacion()))
                        .apellido1( getFirstWord(cliente.getApellidos() ) )
                        .apellido2( getSecondWord(cliente.getApellidos() ) )
                        .nombre1( getFirstWord(cliente.getNombres() ) )
                        .nombre2( getSecondWord(cliente.getNombres() ) )
                        .build())
                .build();
        return result;
    }

    private String getFirstWord(String totalWord){
        String[] wordsArray = totalWord.split(" ");
        if(wordsArray.length == 0 ){
            return " ";
        }
        return wordsArray[0];
    }

    private String getSecondWord(String totalWord){
        String[] wordsArray = totalWord.split(" ");
        if(wordsArray.length == 0 ){
            return " ";
        }
        return wordsArray[1];
    }
    //TODO Se debe realizar el mapeo de todos los tipos de documentos para Bizagi
    private String identifyTypeId(String typeId){
        if("CC".equalsIgnoreCase(typeId)){
            return "2";
        }
        return "NA";
    }

}
