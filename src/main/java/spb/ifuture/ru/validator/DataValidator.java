package spb.ifuture.ru.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DataValidator {
    private static final Pattern PATTERN = Pattern.compile("\\p{Alpha}");

    public void validateArray(String... arg){
        for (String value: arg) {
            validateValue(value);
        }
    }

    public void validateValue(String value){
        Matcher matcher = PATTERN.matcher(value);
        if(matcher.find()){
            throw new RuntimeException("Incorrect symbol " + value + ". All values must be a numbers!");
        }
    }
}
