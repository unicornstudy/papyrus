package papyrus.article.domain.repository;

import org.springframework.data.domain.Pageable;
import papyrus.article.domain.Document;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    void save(Message message);
    List<Document> findAllByCursor(Long cursorId, int limit);
    Optional<Document> findById(Long id);
}
