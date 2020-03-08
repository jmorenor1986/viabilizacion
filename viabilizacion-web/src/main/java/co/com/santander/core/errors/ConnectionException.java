package co.com.santander.core.errors;

import lombok.Getter;
import org.springframework.http.HttpMethod;

public class ConnectionException extends RuntimeException {
    @Getter
    private String url;
    @Getter
    private HttpMethod method;
    @Getter
    private String params;

    public ConnectionException(String message,Throwable cause, String url, HttpMethod method, String params){
        super(message,cause);
        this.method = method;
        this.url = url;
        this.method = method;
        this.params = params;
    }

}
