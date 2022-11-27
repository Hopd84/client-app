package spb.ifuture.ru.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

import static spb.ifuture.ru.util.Constants.REST_BASE_URL;
import static spb.ifuture.ru.util.Constants.TIMEOUT;

@Configuration
public class ApplicationConfig {
    @Bean("restWebClient")
    public WebClient webClient(){
        return WebClient.builder()
                        .baseUrl(REST_BASE_URL)
                        .clientConnector(new ReactorClientHttpConnector(retrieveHttpClient()))
                        .build();
    }

    private HttpClient retrieveHttpClient(){
        return HttpClient.create()
                         .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
                         .doOnConnected(connection -> {
                             connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                             connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                         });
    }
}
