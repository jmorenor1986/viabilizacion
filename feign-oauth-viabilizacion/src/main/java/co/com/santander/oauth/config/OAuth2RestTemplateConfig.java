package co.com.santander.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class OAuth2RestTemplateConfig {

	@Value("${oauth.keycloak.url-token}")
	private String tokenUrl;
	
	@Value("${oauth.keycloak.client-id}")
	private String clientId;
	
	@Value("${oauth.keycloak.grant-type}")
	private String grantType;
	
	@Value("${oauth.keycloak.client-secret}")
	private String clientSecret;

	@Bean
	protected OAuth2ProtectedResourceDetails resource() {
		ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
		clientCredentialsResourceDetails.setAccessTokenUri(tokenUrl);
		clientCredentialsResourceDetails.setClientId(clientId);
		clientCredentialsResourceDetails.setClientSecret(clientSecret);
		clientCredentialsResourceDetails.setGrantType(grantType);
		
		return clientCredentialsResourceDetails;
	}

	@Bean
	public OAuth2RestOperations restTemplate() {
		AccessTokenRequest atr = new DefaultAccessTokenRequest();
		return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
	}
	
}
