package papyrus.common.api.koGpt;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KoGptRequest {
    String prompt;
    Integer maxTokens;
    Double topicP;
    Double temperature;
}
