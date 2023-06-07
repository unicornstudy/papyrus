package papyrus.article.infrastructure.rabbitmq.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Message {

    private String title;
    private String reporter;
    private String category;
    private String press;
    private List<String> paragraphs;
    private String platform;
}
