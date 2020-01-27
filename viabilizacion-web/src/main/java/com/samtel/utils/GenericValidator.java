package com.samtel.utils;

import com.samtel.errors.MandatoryFieldException;

public abstract class GenericValidator<T> {

    public static final String MESSAGE_MANDATORY = "El campo  %s es obligatorio";
    public static final int CODE_MANDATORY = 400;

    protected abstract boolean validateObject(T dto);


    public boolean validateMandatory(Object parameter) {
        if (parameter instanceof String) {
            if (((String) parameter).isEmpty()) {
                throw new MandatoryFieldException(String.format(MESSAGE_MANDATORY, parameter.getClass().getName()), CODE_MANDATORY);
            }
            return true;
        }
        return false;
    }
}
