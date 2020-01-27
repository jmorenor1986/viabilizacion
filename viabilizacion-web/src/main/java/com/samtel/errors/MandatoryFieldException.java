package com.samtel.errors;

public class MandatoryFieldException extends BusinessException {
    public MandatoryFieldException(String message, Integer code) {
        super(message, code);
    }
}
