package spb.ifuture.ru.util;

import lombok.Getter;

@Getter
public final class Constants {
    public static final Integer TIMEOUT = 6000;
    public static final String REST_BASE_URL = "http://localhost:8080/api/v1";

    private Constants(){}
}
