package papyrus.article.domain.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import papyrus.article.domain.ElasticSearchArticle;

public interface ElasticSearchArticleRepository extends ElasticsearchRepository<ElasticSearchArticle, Long>,
        CrudRepository<ElasticSearchArticle, Long> {
}
