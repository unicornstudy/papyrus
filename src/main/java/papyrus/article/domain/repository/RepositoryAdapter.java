package papyrus.article.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import papyrus.article.domain.ArticleFactory;
import papyrus.article.domain.Document;
import papyrus.article.domain.News;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

@RequiredArgsConstructor
@Component
public class RepositoryAdapter implements ArticleRepository {

    private final DocumentRepository documentRepository;

    private final NewsRepository newsRepository;

    @Override
    public void save(Message message) {
        Document document = (Document) ArticleFactory.DOCUMENT.createArticle(message);
        News news = (News) ArticleFactory.NEWS.createArticle(message);

        newsRepository.save(news);
        documentRepository.save(document);
    }
}
