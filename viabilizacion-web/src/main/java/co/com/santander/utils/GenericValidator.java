package co.com.santander.utils;

import co.com.santander.core.errors.MandatoryFieldException;
import co.com.santander.core.errors.NumberException;

import java.math.BigInteger;

public abstract class GenericValidator<T> {

    public static final String MESSAGE_MANDATORY = "El campo  %s es obligatorio";
    public static final String MESSAGE_NUMBER = "El campo  %s requiere un formato numerico";
    public static final int CODE_MANDATORY = 400;

    protected abstract boolean validateObject(T dto);


    public boolean validateMandatory(Object parameter, String label) {
        if (parameter instanceof String) {
            if (((String) parameter).isEmpty()) {
                throw new MandatoryFieldException(String.format(MESSAGE_MANDATORY, label), CODE_MANDATORY);
            }
            return true;
        } else if (parameter == null) {
            throw new MandatoryFieldException(String.format(MESSAGE_MANDATORY, label), CODE_MANDATORY);
        }
        return false;
    }

    public boolean validateNumber(Object parameter, String label) {
        try {
            new BigInteger((String) parameter);
            return true;
        } catch (NumberFormatException ne) {
            throw new NumberException(String.format(MESSAGE_NUMBER, label), CODE_MANDATORY);
        }
    }
}
