package com.colibear.core.net;

import com.colibear.core.net.data.RequestEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.logging.Level;

@Slf4j
@Validated
@Component("client")
public class DefaultClient implements Client {
    private WebClientBuilderFactory webClientBuilderFactory;

    @Autowired
    public DefaultClient(WebClientBuilderFactory webClientBuilderFactory) {
        this.webClientBuilderFactory = webClientBuilderFactory;
    }

    @Override
    public <T> T call(@NotNull RequestEndpoint endpoint, @NotNull Class<T> clazz) {
        return request(endpoint, clazz);
    }

    private <T> T request(RequestEndpoint endpoint, Class<T> clazz) {
        Mono<T> mono = webClientBuilderFactory
            .configuration()
            .endpoint(endpoint)
            .newInstance()
            .retrieve()
            .bodyToMono(clazz);

        if (webClientBuilderFactory.useLogging()) {
            Level logLevel = webClientBuilderFactory.getLogLevel();

            if (logLevel == null) {
                mono.log(webClientBuilderFactory.getLogCategory());
            } else {
                mono.log(webClientBuilderFactory.getLogCategory(), logLevel);
            }
        }

        return mono.block();
    }
}
