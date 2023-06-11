package papyrus.common.api.chatGpt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptMessage {
    private String role;
    private String content;
}
