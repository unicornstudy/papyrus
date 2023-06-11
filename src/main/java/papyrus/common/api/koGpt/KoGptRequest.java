package papyrus.common.api.koGpt;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class KoGptRequest {
    String prompt;
    Integer maxTokens;
    Double topicP;
    Double temperature;

    public static KoGptRequest of(String paragraphs) {
        return KoGptRequest.builder()
                .prompt(paragraphs + "\n 한줄로 요약")
                .maxTokens(128)
                .temperature(0.7)
                .topicP(0.7)
                .build();
    }
}
