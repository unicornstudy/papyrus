package papyrus.common.api.chatGpt;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ChatGptUsage {
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;
}
