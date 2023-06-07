package papyrus.article.domain.repository;

import org.springframework.data.domain.Pageable;
import papyrus.article.domain.Document;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

import java.util.List;

public interface ArticleRepository {

    void save(Message message);
    List<Document> findAllByCursor(Long cursorId, int limit);
}
