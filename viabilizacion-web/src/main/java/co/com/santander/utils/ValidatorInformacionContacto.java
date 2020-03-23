package co.com.santander.utils;

import co.com.santander.core.domain.solicitud.Cliente;
import co.com.santander.core.domain.solicitud.informacioncontacto.ResponseInformacionContacto;
import lombok.Builder;

@Builder
public class ValidatorInformacionContacto {

    public Boolean evaluaDatosContacto(ResponseInformacionContacto responseInformacionContacto, Cliente cliente) {
        if (responseInformacionContacto == null) {
            return Boolean.FALSE;
        }
        //Evalua en los numeros de telefono
        Boolean telefono = Boolean.FALSE;
        if (responseInformacionContacto.getNumerosTelefono() != null) {
            telefono = responseInformacionContacto
                    .getNumerosTelefono()
                    .stream()
                    .filter(item -> !(item == null))
                    .filter(item -> !(item.isEmpty()))
                    .filter(tel -> cliente.getTelefono().equalsIgnoreCase(tel))
                    .findAny()
                    .isPresent();

        }
        //En el caso de que la respuesta sea TRUE debe responder que si encontro informacion
        if (telefono) {
            return Boolean.TRUE;
        }
        //Evalua correos electronicos
        Boolean correo = Boolean.FALSE;
        if(responseInformacionContacto.getCorreoElectronico() != null){
            correo = responseInformacionContacto
                    .getCorreoElectronico()
                    .stream()
                    .filter(item -> !(item == null))
                    .filter(item -> !(item.isEmpty()))
                    .filter(correoEl -> cliente.getCorreoElectronico().equalsIgnoreCase(correoEl))
                    .findAny()
                    .isPresent();
        }
        //En el caso de que la respuesta sea TRUE debe responder que si encontro informacion
        if (correo) {
            return Boolean.TRUE;
        }

        Boolean celular = Boolean.FALSE;
        if(responseInformacionContacto.getNumeroCelular() != null){
            //Evalua Celular
            celular = responseInformacionContacto
                    .getCorreoElectronico()
                    .stream()
                    .filter(item -> !(item == null))
                    .filter(item -> !(item.isEmpty()))
                    .filter(correoEl -> cliente.getCorreoElectronico().equalsIgnoreCase(correoEl))
                    .findAny()
                    .isPresent();
        }

        //En el caso de que la respuesta sea TRUE debe responder que si encontro informacion
        if (correo) {
            return Boolean.TRUE;
        }

        //Si no encontro ningun dato que coincida retorna false
        return Boolean.FALSE;

    }
}
