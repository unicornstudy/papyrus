package papyrus.article.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import papyrus.article.domain.ArticleFactory;
import papyrus.article.domain.Document;
import papyrus.article.domain.News;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Document> findAllByCursor(Long cursorId, int limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "id"));

        return Optional.ofNullable(cursorId)
                .map(id -> documentRepository.findAllByCursor(id, pageable))
                .orElseGet(() -> documentRepository.findAll(pageable).getContent());
    }
}
