package papyrus.common.api.chatGpt;

import lombok.Getter;

import java.util.List;

@Getter
public class ChatGptResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private ChatGptUsage usage;
    private List<ChatGptChoice> choices;

    public String getParagraphs() {
        return choices.get(0).getMessage().getContent();
    }
}
