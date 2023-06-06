package papyrus.article.domain.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import papyrus.article.domain.Document;

public interface DocumentRepository extends ElasticsearchRepository<Document, Long>,
        CrudRepository<Document, Long> {
}
