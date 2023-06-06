package papyrus.article.domain.repository;

import papyrus.article.infrastructure.rabbitmq.dto.Message;

public interface ArticleRepository {

    void save(Message message);
}
