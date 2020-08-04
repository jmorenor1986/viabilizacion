package co.com.santander.core.domain.solicitud;

import co.com.santander.core.errors.BusinessException;
import co.com.santander.utils.GenericValidator;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.DecimalFormat;

@Component
public class ClienteValidator extends GenericValidator<Cliente> {

    public static final String VALOR_MAXIMO_SOLICTADO = "20000000";
    private final String MESSAGE_CANAL_ORIGEN = "El monto solicitado (%s) es superior al monto permitido para el canal de origen (%s)";

    @Override
    public boolean validateObject(Cliente dto) {
        if (validateMandatory(dto.getActividad(), "ACTIVIDAD_ECONOMICA")
                && validateMandatory(dto.getAnoNacimiento(), "ANIO_NACIMIENTO")
                && validateMandatory(dto.getApellidos(), "APELLIDOS")
                && validateMandatory(dto.getCelular(), "CELULAR")
                && validateMandatory(dto.getCorreoElectronico(), "CORREO_ELECTRONICO")
                && validateMandatory(dto.getDireccion(),"DIRECCION")
                && validateMandatory(dto.getIngresos(), "INGRESOS")
                && validateMandatory(dto.getNombres(), "NOMBRES")
                && validateMandatory(dto.getNumeroIdentificacion(), "NUMERO_DE_IDENTIFICACION")
                && validateMandatory(dto.getPlazo(), "PLAZO")
                && validateMandatory(dto.getTelefono(), "TELEFONO")
                && validateMandatory(dto.getTipoIdentificacion(), "TIPO_IDENTIFICACION")
                && validateMandatory(dto.getValorSolicitado(), "VALOR_SOLICITADO")
                && validateMandatory(dto.getCanalOrigen(), "CANAL_ORIGEN")
                //Validamos los campos numericos
                && validateNumber(dto.getNumeroIdentificacion(), "NUMERO_DE_IDENTIFICACION")
                && validateNumber(dto.getTelefono(), "NUMERO_DE_TELEFONO")
                && validateNumber(dto.getCelular(), "NUMERO_DE_CELULAR")
                && validateNumber(dto.getAnoNacimiento(), "ANIO_DE_NACIMIENTO")
                && validateNumber(dto.getValorSolicitado(), "VALOR_SOLICITADO")
                && validateNumber(dto.getIngresos(), "INGRESOS")
                && validateNumber(dto.getPlazo(), "PLAZO")
                && validateNumber(dto.getCanalOrigen(), "CANAL_ORIGEN")
                //Validamos la regla de negocio 'Si el canal origen es 1 y el valor solicitado es superior a 10 millones debe ser negado'
                && validateCanalOrigen(dto)
        )
            return true;



        return false;
    }

    private boolean validateCanalOrigen(Cliente dto){
        if("1".equalsIgnoreCase(dto.getCanalOrigen())){
            BigInteger valorSolicitado = new BigInteger(dto.getValorSolicitado());
            if(valorSolicitado.compareTo(new BigInteger(VALOR_MAXIMO_SOLICTADO)) ==1){
                DecimalFormat formatter = new DecimalFormat("###,###.##");
                String valor = formatter.format( new BigInteger(dto.getValorSolicitado() ) );
                throw new BusinessException(String.format(MESSAGE_CANAL_ORIGEN, valor , dto.getCanalOrigen()) ,CODE_MANDATORY);
            }
        }
        return true;
    }
}
