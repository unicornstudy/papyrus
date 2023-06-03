package papyrus.article.infrastructure.rabbitmq.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import papyrus.article.domain.ElasticSearchArticle;
import papyrus.article.domain.PostgreArticle;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class RabbitmqMessage {

    private String title;
    private String reporter;
    private String category;
    private String press;
    private List<String> paragraphs;

    public ElasticSearchArticle toElasticSearchArticle(){
        return ElasticSearchArticle.builder()
                .paragraphs(getParagraphs())
                .press(getPress())
                .title(getTitle())
                .category(getCategory())
                .press(getPress())
                .reporter(getReporter())
                .build();
    }

    public PostgreArticle toPostgreArticle(){
        return PostgreArticle.builder()
                .paragraphs(getParagraphs())
                .press(getPress())
                .title(getTitle())
                .category(getCategory())
                .press(getPress())
                .reporter(getReporter())
                .build();
    }
}
