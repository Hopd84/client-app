package spb.ifuture.ru.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class CustomCallableGet implements Callable<Long> {
    private final int id;

    private final WebClient webClient;

    @Override
    public Long call() throws Exception {
        return webClient.get()
                        .uri("/accounts/{id}", id)
                        .retrieve()
                        .bodyToMono(Long.class)
                        .block();
    }
}
