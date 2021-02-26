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
        String json="{\"beerId\":\"9dfbddc2-e2c1-4f61-8857-764c4d11f116\",\"beerName\":\"Beer name\",\"beerStyle\":\"Ale\",\"upc\":123566789123,\"price\":12.99,\"createdDate\":\"2021-02-26T22:01:23.461617+08:00\",\"lastUpdatedDate\":\"2021-02-26T22:01:23.461643+08:00\"}\n";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}