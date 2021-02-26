package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@JsonTest
@ActiveProfiles("kebab")
public class BeerDtoKebabTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void testKebabCase() throws JsonProcessingException {
        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }
}
