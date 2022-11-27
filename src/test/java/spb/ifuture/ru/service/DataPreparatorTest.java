package spb.ifuture.ru.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import spb.ifuture.ru.TestDataProvider;
import spb.ifuture.ru.config.RuntimeData;
import spb.ifuture.ru.validator.DataValidator;

@ExtendWith(MockitoExtension.class)
class DataPreparatorTest {
    private DataPreparator dataPreparator;
    private RuntimeData runtimeData;
    private DataValidator dataValidator;

    @BeforeEach
    public void init(){
        dataValidator = new DataValidator();
        runtimeData = TestDataProvider.getRuntimeData1Stub();
        dataPreparator = new DataPreparator(runtimeData, dataValidator);
    }

    @Test
    void prepareDateFromConsole() {
        final String[] inputDataConsoleStub = TestDataProvider.getInputData1Stub().toArray(new String[TestDataProvider.getInputData1Stub().size()]);
        final RuntimeData runtimeDataStub = TestDataProvider.getRuntimeData3Stub();

        Assertions.assertEquals(runtimeDataStub, dataPreparator.prepareDate(inputDataConsoleStub));
    }
}