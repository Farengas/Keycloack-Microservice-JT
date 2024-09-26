package com.javatechie.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class OAuth2AccessTokenInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof JwtAuthenticationToken) {
            JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
            String tokenValue = jwtAuthenticationToken.getToken().getTokenValue();
            requestTemplate.header("Authorization", "Bearer " + tokenValue);
        }
    }
    /*
    public static final String BEARER = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";
    private final String tokenType;
    private final String header;
    private final String clientRegistrationId;
    private final OAuth2AuthorizedClientManager authorizedClientManager;
    private static final Authentication ANONYMOUS_AUTHENTICATION = new AnonymousAuthenticationToken("anonymous", "anonymousUser", AuthorityUtils.createAuthorityList(new String[]{"ROLE_ANONYMOUS"}));



    public OAuth2AccessTokenInterceptor(OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
        this((String)null, oAuth2AuthorizedClientManager);
    }

    public OAuth2AccessTokenInterceptor(String clientRegistrationId, OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
        this("Bearer", "Authorization", clientRegistrationId, oAuth2AuthorizedClientManager);
    }

    public OAuth2AccessTokenInterceptor(String tokenType, String header, String clientRegistrationId, OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
        this.tokenType = tokenType;
        this.header = header;
        this.clientRegistrationId = clientRegistrationId;
        this.authorizedClientManager = oAuth2AuthorizedClientManager;
    }

    @Override
    public void apply(RequestTemplate template) {
        OAuth2AccessToken token = this.getToken(template);
        String extractedToken = String.format("%s %s", this.tokenType, token.getTokenValue());
        template.header(this.header, new String[0]);
        template.header(this.header, new String[]{extractedToken});
    }

    public OAuth2AccessToken getToken(RequestTemplate template) {
        OAuth2AccessToken token;
        if (StringUtils.hasText(this.clientRegistrationId)) {
            token = this.getToken(this.clientRegistrationId);
            if (token != null) {
                return token;
            }
        }

        token = this.getToken(getServiceId(template));
        if (token != null) {
            return token;
        } else {
            throw new IllegalStateException("OAuth2 token has not been successfully acquired.");
        }
    }

    protected OAuth2AccessToken getToken(String clientRegistrationId) {
        if (!StringUtils.hasText(clientRegistrationId)) {
            return null;
        } else {
            Authentication principal = SecurityContextHolder.getContext().getAuthentication();
            if (principal == null) {
                principal = ANONYMOUS_AUTHENTICATION;
            }

            OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId(clientRegistrationId).principal(principal).build();
            OAuth2AuthorizedClient authorizedClient = this.authorizedClientManager.authorize(authorizeRequest);
            return (OAuth2AccessToken) Optional.ofNullable(authorizedClient).map(OAuth2AuthorizedClient::getAccessToken).orElse((OAuth2AccessToken) null);
        }
    }

    private static String getServiceId(RequestTemplate template) {
        Target<?> feignTarget = template.feignTarget();
        Assert.notNull(feignTarget, "FeignTarget may not be null.");
        String url = feignTarget.url();
        Assert.hasLength(url, "Url may not be empty.");
        URI originalUri = URI.create(url);
        return originalUri.getHost();
    }

     */

}

    /*
    private OAuth2AuthorizedClientManager manager;


    @Override
    public void apply(RequestTemplate requestTemplate) {
        OAuth2AuthorizedClient client = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("google")
                .principal("internal")
                .build());
        String accessToken = client.getAccessToken().getTokenValue();
        requestTemplate.header("Authorization", "Bearer " + accessToken);
    }
    }

     */
/*
        String tokenType =
                String.valueOf(manager
                        .authorize(OAuth2AuthorizeRequest.withClientRegistrationId("google")
                                .principal("internal")
                                .build())
                        .getAccessToken()
                        .getTokenType());
        requestTemplate.header("Authorization", "Bearer " + tokenType);
    }

 */



