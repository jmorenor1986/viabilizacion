package co.com.santander.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {

	private static final String AUTHORIZATION_HEADER = "Authorization";

	private static final String BEARER_TOKEN_TYPE = "Bearer";

	@Autowired
	OAuth2RestOperations restTemplate;

	@Override
	public void apply(RequestTemplate template) {
		if (template.headers().containsKey(AUTHORIZATION_HEADER)) 
			log.warn("The Authorization token has been already set");
		else {
			log.info("Constructing Header {} for Token {}", AUTHORIZATION_HEADER, BEARER_TOKEN_TYPE);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth instanceof AnonymousAuthenticationToken) {
				log.warn("Role is anonymous, no token will be created. Probably called service without security");
			} else {
				String authorization = restTemplate.getAccessToken().getValue();
				template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, authorization));
			}
		}
	}
}
