package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    //serialize java -> json
    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        String json="{\"beerName\":\"Beer name\",\"beerStyle\":\"Ale\",\"upc\":123566789123,\"price\":\"12.99\",\"createdDate\":\"2021-02-26T22:35:22+0800\",\"lastUpdatedDate\":\"2021-02-26T22:35:22.653037+08:00\",\"myLocalDate\":\"20210226\",\"beerId\":\"7781ba42-d881-4865-995c-7d4bad839b6c\"}\n";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}