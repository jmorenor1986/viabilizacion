package co.com.santander.core.errors;

public class NumberException extends BusinessException {

    public NumberException(String message, Integer code) {
        super(message, code);
    }
}
