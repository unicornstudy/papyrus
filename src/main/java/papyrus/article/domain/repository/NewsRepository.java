package papyrus.article.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import papyrus.article.domain.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
