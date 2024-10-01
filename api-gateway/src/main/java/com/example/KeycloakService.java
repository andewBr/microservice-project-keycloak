package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import java.util.*;

@Service
public class KeycloakService {


    private WebClient webClient = WebClient.builder().build();

    @Autowired
    private ReactiveClientRegistrationRepository clientRegistrationRepository;

    public Mono<Map<String, Object>> getToken(String login, String password)
    {
        return clientRegistrationRepository.findByRegistrationId("keycloak")
                .flatMap(clientRegistration -> webClient.post()

                        .uri(clientRegistration.getProviderDetails().getTokenUri())

                        .body(BodyInserters.fromFormData(OAuth2ParameterNames.GRANT_TYPE,
                                        clientRegistration.getAuthorizationGrantType().getValue())
                                .with(OAuth2ParameterNames.CLIENT_ID,
                                        clientRegistration.getClientId())
                                .with(OAuth2ParameterNames.CLIENT_SECRET,
                                        clientRegistration.getClientSecret())
                                .with(OAuth2ParameterNames.USERNAME, login)
                                .with(OAuth2ParameterNames.PASSWORD,
                                        password))
                        .retrieve()
                        .bodyToMono(new
                                            ParameterizedTypeReference<Map<String, Object>>() {
                                            })
                        .onErrorResume(WebClientResponseException.class, e -> Mono.error(
                                new
                                        ResponseStatusException(e.getStatusCode(), e.getResponseBodyAsString()))));
    }

    public Mono<Map<String, Object>> validateToken(String token) {
        return clientRegistrationRepository.findByRegistrationId("keycloak")
                .flatMap(clientRegistration -> {
                    String introspectUri = clientRegistration.getProviderDetails().getIssuerUri()
                            + "/protocol/openid-connect/token/introspect";

                    return webClient.post()
                            .uri(introspectUri)
                            .body(BodyInserters.fromFormData(OAuth2ParameterNames.CLIENT_ID, clientRegistration.getClientId())
                                    .with(OAuth2ParameterNames.CLIENT_SECRET, clientRegistration.getClientSecret())
                                    .with("token", token))
                            .retrieve()
                            .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {
                            })
                            .onErrorResume(WebClientResponseException.class, e ->
                                    Mono.error(new ResponseStatusException(e.getStatusCode(), e.getResponseBodyAsString())));
                });
    }


}

