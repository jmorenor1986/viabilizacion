package co.com.santander.core.domain.solicitud;

import co.com.santander.utils.GenericValidator;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator extends GenericValidator<Cliente> {

    @Override
    public boolean validateObject(Cliente dto) {
        if (validateMandatory(dto.getActividad())
                && validateMandatory(dto.getAnoNacimiento())
                && validateMandatory(dto.getApellidos())
                && validateMandatory(dto.getCelular())
                && validateMandatory(dto.getCorreoElectronico())
                && validateMandatory(dto.getDireccion())
                && validateMandatory(dto.getIngresos())
                && validateMandatory(dto.getNombres())
                && validateMandatory(dto.getNumeroIdentificacion())
                && validateMandatory(dto.getPlazo())
                && validateMandatory(dto.getTelefono())
                && validateMandatory(dto.getTipoIdentificacion())
                && validateMandatory(dto.getValorSolicitado()))
            return true;
        return false;
    }
}
