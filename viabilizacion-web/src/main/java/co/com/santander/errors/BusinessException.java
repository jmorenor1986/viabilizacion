package co.com.santander.errors;

public class BusinessException extends RuntimeException {
    private final Integer code;

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
