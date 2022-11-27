package spb.ifuture.ru.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import spb.ifuture.ru.config.RuntimeData;
import spb.ifuture.ru.exception.ClientException;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class Service {
    private final WebClient webClient;

    public void execute(RuntimeData runtimeData){
        int rCount = runtimeData.getRCount();
        List<Integer> idList = runtimeData.getIndexList().stream()
                                          .map(Integer::parseInt)
                                          .toList();

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        try{
            for (int i = 0; i < rCount + runtimeData.getWCount(); i++) {
                if (i < rCount) {
                    CustomCallableGet customCallableGet = new CustomCallableGet(idList.get(i), webClient);
                    executorService.submit(customCallableGet);
                } else {
                    CustomCallableAdd customCallableAdd = new CustomCallableAdd(idList.get(i), getRandomValue(),
                                                                                webClient);
                    executorService.submit(customCallableAdd);
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ClientException("Incorrect input data! Write correct index range, that is solve the problem.");
        }
        executorService.shutdown();
    }

    private int getRandomValue() {
        Random random = new SecureRandom();
        return random.nextInt(201) - 100;
    }
}
