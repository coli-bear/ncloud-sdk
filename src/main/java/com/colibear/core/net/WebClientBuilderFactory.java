package com.colibear.core.net;

import com.colibear.core.net.data.RequestEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.logging.Level;

@Validated
@Component
public class WebClientBuilderFactory {
    private WebClient.Builder webClientBuilder;
    private WebClient webClient;
    private String logCategory = "";// using webclient log
    private Level logLevel;
    private RequestEndpoint endpoint;    // request infos
    private WebClientResponseSpec webClientResponseSpec;


    @Autowired
    public WebClientBuilderFactory(@NotNull WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public WebClientBuilderFactory log(String logCategory) {
        this.logCategory = logCategory;
        return this;
    }

    public WebClientBuilderFactory logLevel(String level) {
        return this;
    }

    public boolean useLogging() {
        return this.logCategory != null;
    }

    public WebClientConfigurator configuration() {
        return new WebClientConfigurator();
    }

    public String getLogCategory() {
        return this.logCategory;
    }

    public WebClientBuilderFactory logLevel(Level level) {
        if (level == null) {
            this.logLevel = Level.INFO;
        } else {
            this.logLevel = level;
        }

        return this;
    }

    public Level getLogLevel() {
        return this.logLevel;
    }

    public class WebClientConfigurator {
        public WebClientConfigurator endpoint(@NotNull RequestEndpoint endpoint) {
            WebClientBuilderFactory.this.endpoint = endpoint;
            return this;
        }

        public WebClientResponseSpec newInstance() {
            webClientBuilder.baseUrl(endpoint.getEndpoint());
            if (endpoint.availableHeaders()) {
                webClientBuilder.defaultHeaders(httpHeaders -> httpHeaders.addAll(endpoint.getHeaders()));
            }

            if (endpoint.availableCookies()) {
                endpoint.getCookies().forEach(cookie ->
                    webClientBuilder.defaultCookies(cookieConsumer ->
                        cookieConsumer.add(cookie.getName(), cookie.getValue()))
                );
            }

            WebClientBuilderFactory.this.webClient = webClientBuilder.build();

            WebClientBuilderFactory.this.webClientResponseSpec = new WebClientResponseSpec();

            return WebClientBuilderFactory.this.webClientResponseSpec;
        }
    }

    public class WebClientResponseSpec {

        public WebClient.ResponseSpec retrieve() {
            WebClient.RequestHeadersUriSpec<?> uriSpec = null;
            WebClient.RequestBodyUriSpec bodyUriSpec = null;

            switch (WebClientBuilderFactory.this.endpoint.getMethod()) {
                case GET:
                    uriSpec = WebClientBuilderFactory.this.webClient.get();
                    break;
                case HEAD:
                    uriSpec = WebClientBuilderFactory.this.webClient.head();
                    break;
                case POST:
                    bodyUriSpec = WebClientBuilderFactory.this.webClient.post();
                    break;
                case PATCH:
                    bodyUriSpec = WebClientBuilderFactory.this.webClient.patch();
                    break;
                case PUT:
                    bodyUriSpec = WebClientBuilderFactory.this.webClient.put();
                    break;
                case OPTIONS:
                    uriSpec = WebClientBuilderFactory.this.webClient.options();
                    break;
                case DELETE:
                    uriSpec = WebClientBuilderFactory.this.webClient.delete();
                    break;
            }

            WebClient.ResponseSpec retrieve = null;
            if (Objects.nonNull(uriSpec)) {
                retrieve = getResponseSpec(uriSpec);
            } else if (Objects.nonNull(bodyUriSpec)) {
                retrieve = getResponseBodySpec(bodyUriSpec);
            }
            return retrieve;
        }

        private WebClient.ResponseSpec getResponseBodySpec(@NotNull WebClient.RequestBodyUriSpec bodyUriSpec) {
            if (WebClientBuilderFactory.this.endpoint.availableBody()) {
                bodyUriSpec.bodyValue(WebClientBuilderFactory.this.endpoint.getBody());
            }

            return bodyUriSpec
                .uri(WebClientBuilderFactory.this.endpoint.getUri())
                .retrieve();
        }

        private WebClient.ResponseSpec getResponseSpec(@NotNull WebClient.RequestHeadersUriSpec<?> uriSpec) {
            return uriSpec
                .uri(WebClientBuilderFactory.this.endpoint.getUri())
                .retrieve();
        }
    }
}
