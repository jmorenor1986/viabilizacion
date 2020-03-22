package co.com.santander.adapters.secondary.rest.access.proxy;

import co.com.santander.adapters.secondary.rest.access.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("proxyRestTemplateServiceImpl")
public class ProxyRestTemplateServiceImpl implements RestTemplateService {

    private RestTemplateService restTemplateService;

    @Autowired
    public ProxyRestTemplateServiceImpl( @Qualifier("restTemplateServiceImpl") RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @Override
    public Optional<String> getWithPathParams(String uri, List<String> pathParams, Optional<Map<String, String>> headers) {
        return restTemplateService.getWithPathParams(uri,pathParams,headers);
    }

    @Override
    public Optional<String> postWithOutParams(String uri, Object request, Optional<Map<String, String>> headers) {
        return restTemplateService.postWithOutParams(uri,request,headers);
    }

    @Override
    public Optional<String> getWithOutParams(String uri, Object request, Optional<Map<String, String>> headers) {
        return restTemplateService.getWithOutParams(uri,request,headers);
    }

    @Override
    public Optional<String> getWithParams(String uri, Map<String, Object> params, Optional<Map<String, String>> headers) {
        return restTemplateService.getWithParams(uri,params,headers);
    }
}
