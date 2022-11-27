package spb.ifuture.ru.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "prop")
public class RuntimeData {
    private int rCount;
    private int wCount;
    private String idList;
    private List<String> indexList = new ArrayList<>();
}
