package co.com.santander.utils;

import co.com.santander.utils.dto.HeaderDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

public class CreateHeadersMap {

    public static Optional<Map<String, String>> generateMap(HeaderDto... key){
        Map<String, String> result = new HashMap<>();
        for(HeaderDto item : key){
            result.put(item.getKey(), item.getValue());
        }
        return Optional.of(result);
    }
}
