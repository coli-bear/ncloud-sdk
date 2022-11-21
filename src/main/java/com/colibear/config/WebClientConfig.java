package com.colibear.config;

import com.colibear.core.net.WebClientBuilderFactory;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient.Builder webClientBuilder() {
        log.debug("add a 'WebClientBuilder.class' to spring application context ");
        HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30 * 1000) // Connection Timeout
            .doOnConnected(connection ->
                connection
                    .addHandlerLast(new ReadTimeoutHandler(10 * 1000, TimeUnit.MILLISECONDS))
                    .addHandlerLast(new WriteTimeoutHandler(10 * 1000, TimeUnit.MILLISECONDS))
            );

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        return WebClient.builder()
            .clientConnector(connector);
    }
}
