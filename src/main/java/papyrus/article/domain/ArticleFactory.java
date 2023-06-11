package papyrus.article.domain;

import java.util.List;
import java.util.stream.Collectors;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

public enum ArticleFactory {

    NEWS {
        @Override
        public Article createArticle(Message message, Long id) {
            return News.builder()
                    .paragraphs(convertParagraphs(message.getParagraphs()))
                    .press(message.getPress())
                    .title(message.getTitle())
                    .category(message.getCategory())
                    .reporter(message.getReporter())
                    .platform(message.getPlatform())
                    .build();
        }
    },
    DOCUMENT {
        @Override
        public Article createArticle(Message message, Long id) {
            return Document.builder()
                    .id(id)
                    .paragraphs(convertParagraphs(message.getParagraphs()))
                    .press(message.getPress())
                    .title(message.getTitle())
                    .category(message.getCategory())
                    .reporter(message.getReporter())
                    .platform(message.getPlatform())
                    .build();
        }
    };

    public abstract Article createArticle(Message message, Long id);

    private static String convertParagraphs(List<String> paragraphs) {
        return paragraphs.stream()
                .collect(Collectors.joining());
    }
}
