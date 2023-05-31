package papyrus.common.api.chatGpt;

import lombok.Getter;

@Getter
public class ChatGptChoice {
    private ChatGptMessage message;
    private String finish_reason;
    private int index;
}
