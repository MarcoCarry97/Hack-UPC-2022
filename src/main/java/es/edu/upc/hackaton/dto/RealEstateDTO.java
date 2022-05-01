package es.edu.upc.hackaton.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Optional;

/* EXAMPLE OUTPUT
{
  "error": "false",
  "response": {
    "solutions": {
      "re_condition": {
        "score": 5
      }
    }
  },
  "time": "2022-05-01T01:04:49.186489",
  "correlation_id": "801309d4-53ff-4285-9d7a-6c4d52e76aa5",
  "version": "2"
}*/

@Getter
@Setter
@JsonDeserialize(using = RealEstateDTODeserializer.class)
public class RealEstateDTO {
    private Double score;
}

class RealEstateDTODeserializer extends StdDeserializer<RealEstateDTO> {

    public RealEstateDTODeserializer() {
        this(null);
    }

    public RealEstateDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public RealEstateDTO deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode productNode = jp.getCodec().readTree(jp);
        RealEstateDTO realEstateDTO = new RealEstateDTO();
        realEstateDTO.setScore(Optional.ofNullable(productNode.get("response").get("solutions").get("re_condition").get("score")).map(JsonNode::doubleValue).orElse(null));
        return realEstateDTO;
    }
}
