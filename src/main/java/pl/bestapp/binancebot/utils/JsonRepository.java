package pl.bestapp.binancebot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.bestapp.binancebot.infrastructure.strategy.domain.Strategy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unchecked")
@Component
public class JsonRepository implements StrategyRepository {

    @Value("${strategy.path}")
    private String jsonStrategyPath;

    public void save(Strategy strategy, String strategyName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(jsonStrategyPath + "/" + strategyName + ".json"), strategy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Strategy get(String strategyName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(jsonStrategyPath + "/" + strategyName + ".json"), Strategy.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
