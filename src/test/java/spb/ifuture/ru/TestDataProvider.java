package spb.ifuture.ru;

import spb.ifuture.ru.config.RuntimeData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TestDataProvider {
    public static RuntimeData getRuntimeData1Stub(){
        List<String> indexList = IntStream.range(1, 16).boxed().map(String::valueOf).toList();

         RuntimeData runtimeData = new RuntimeData();
         runtimeData.setRCount(5);
         runtimeData.setWCount(10);
         runtimeData.setIndexList(indexList);

        return runtimeData;
    }

    public static RuntimeData getRuntimeData2Stub(){
        List<String> indexList = IntStream.range(1, 6).boxed().map(String::valueOf).toList();

        RuntimeData runtimeData = new RuntimeData();
        runtimeData.setRCount(5);
        runtimeData.setWCount(10);
        runtimeData.setIndexList(indexList);

        return runtimeData;
    }

    public static RuntimeData getRuntimeData3Stub(){
        List<String> indexList = IntStream.range(1, 11).boxed().map(String::valueOf).toList();

        RuntimeData runtimeData = new RuntimeData();
        runtimeData.setRCount(5);
        runtimeData.setWCount(10);
        runtimeData.setIndexList(indexList);

        return runtimeData;
    }

    public static List<String> getInputData1Stub(){
        List<String> indexList = IntStream.range(1, 11).boxed().map(String::valueOf).toList();
        List<String> inputDataList = new ArrayList<>(List.of("5", "10"));
        inputDataList.addAll(indexList);
        return inputDataList;
    }
}
