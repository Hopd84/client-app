package spb.ifuture.ru.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spb.ifuture.ru.service.DataPreparator;
import spb.ifuture.ru.service.Service;

@Component
@RequiredArgsConstructor
public class CustomCommandLineRunner implements CommandLineRunner {
    private final DataPreparator dataPreparator;
    private final Service service;

    @Override
    public void run(String... args) {
        RuntimeData runtimeData = dataPreparator.prepareDate(args);
        service.execute(runtimeData);
    }
}
