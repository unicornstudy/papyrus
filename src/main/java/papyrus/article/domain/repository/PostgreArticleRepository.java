package papyrus.article.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import papyrus.article.domain.PostgreArticle;

public interface PostgreArticleRepository extends JpaRepository<PostgreArticle, Long> {
}
