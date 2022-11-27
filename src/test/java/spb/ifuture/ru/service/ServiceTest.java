package spb.ifuture.ru.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import spb.ifuture.ru.TestDataProvider;
import spb.ifuture.ru.config.RuntimeData;
import spb.ifuture.ru.exception.ClientException;

@ExtendWith(MockitoExtension.class)
class ServiceTest {
    private Service service;

    @Mock
    private WebClient webClient;

    @BeforeEach
    public void init(){
        service = new Service(webClient);
    }

    @Test
    void executeWithCorrectRuntimeData() {
        RuntimeData runtimeDataStub = TestDataProvider.getRuntimeData1Stub();

        Assertions.assertDoesNotThrow(() -> service.execute(runtimeDataStub));
    }

    @Test
    void executeWithIncorrectRuntimeData() {
        RuntimeData runtimeDataStub = TestDataProvider.getRuntimeData2Stub();

        Assertions.assertThrows(ClientException.class, () -> service.execute(runtimeDataStub));
    }
}