package spb.ifuture.ru.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spb.ifuture.ru.config.RuntimeData;
import spb.ifuture.ru.validator.DataValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataPreparator {
    private int from;
    private int to;
    private final RuntimeData runtimeData;
    private final DataValidator dataValidator;

    public RuntimeData prepareDate(String... args){
        String preIndexList;
        List<String> indexList = new ArrayList<>();

        if(args.length > 2) {
            dataValidator.validateArray(args);
            int rCount = Integer.parseInt(args[0].trim());
            int wCount = Integer.parseInt(args[1].trim());
            preIndexList = args[2];

            prepareRuntimeData(preIndexList, indexList, Arrays.copyOfRange(args, 2, args.length));
            fillRuntimeData(runtimeData, rCount, wCount, indexList);
        }else{
            preIndexList = runtimeData.getIdList();

            dataValidator.validateValue(preIndexList);
            prepareRuntimeData(preIndexList, indexList, preIndexList.split(" "));
            runtimeData.setIndexList(indexList);
        }
        return runtimeData;
    }

    private void prepareRuntimeData(String preIndexList, List<String> indexList, String... args){
        if (preIndexList.contains("-")) {
            String[] fromToArray = preIndexList.split("-");
            defineStartEnd(Integer.parseInt(fromToArray[0]), Integer.parseInt(fromToArray[1]));
            fillIndexList(indexList);
        }else{
            fillIndexList(indexList, args);
        }
    }

    private void defineStartEnd(int firstValue, int secondValue) {
        if(firstValue > secondValue){
            from = secondValue;
            to = firstValue;
        }else{
            from = firstValue;
            to = secondValue;
        }
    }

    private void fillIndexList(List<String> indexList) {
        if (from < to) {
            for (int i = from; i <= to; i++) {
                indexList.add(String.valueOf(i));
            }
        } else if(from == to) {
            indexList.add(String.valueOf(from));
        }
    }

    private void fillIndexList(List<String> indexList, String... args) {
        Collections.addAll(indexList, args);
    }

    private void fillRuntimeData(RuntimeData runtimeData, Integer rCount, Integer wCount, List<String> indexList){
        runtimeData.setRCount(rCount);
        runtimeData.setWCount(wCount);
        runtimeData.setIndexList(indexList);
    }
}
