package papyrus.common.api.chatGpt;

import lombok.Getter;

import java.util.List;

@Getter
public class ChatGptGeneration {
    private String model;
    private List<ChatGptMessage> messages;
    private double temperature;
}
