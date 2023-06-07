package papyrus.article.application.dto;

import lombok.Builder;
import lombok.Getter;
import papyrus.article.domain.Document;

@Getter
@Builder
public class ArticleResponse {
    private String title;
    private String paragraphs;
    private String reporter;
    private String category;
    private String press;
    private String platform;

    public static ArticleResponse from(Document document) {
        return ArticleResponse.builder()
                .title(document.getTitle())
                .paragraphs(document.getParagraphs())
                .reporter(document.getReporter())
                .category(document.getCategory())
                .press(document.getPress())
                .platform(document.getPlatform())
                .build();
    }
}
