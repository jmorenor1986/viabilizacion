package co.com.santander.adapters.secondary.rest.access;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RestTemplateService {

    public Optional<String> getWithPathParams(String uri, List<String> pathParams, Optional<Map<String, String>> headers);

    public Optional<String> postWithOutParams(String uri, Object request, Optional<Map<String, String>> headers);

    public Optional<String> getWithOutParams(String uri, Object request, Optional<Map<String, String>> headers);

    public Optional<String> getWithParams(String uri, Map<String, Object> params, Optional<Map<String, String>> headers);

}
