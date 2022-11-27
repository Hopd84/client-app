package spb.ifuture.ru.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class CustomCallableAdd implements Runnable {
    private final int id;
    private final int value;
    private final WebClient webClient;

    @Override
    public void run() {
        webClient.put()
                 .uri(uriBuilder -> uriBuilder.path("/accounts/" + id)
                         .queryParam("value", value)
                         .build())
                 .retrieve()
                 .toBodilessEntity()
                 .then()
                 .block();
    }
}
