package papyrus.article.domain.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import papyrus.article.domain.Document;

import java.util.List;

public interface DocumentRepository extends ElasticsearchRepository<Document, Long>,
        CrudRepository<Document, Long> {
    @Query("{\"bool\": {\"must\": {\"range\": {\"id\": {\"lt\": \"?0\"}}}}}")
    List<Document> findAllByCursor(@Param("cursorId") Long cursorId, Pageable pageable);
}
