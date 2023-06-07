package papyrus.article.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import papyrus.article.application.dto.ArticleResponse;
import papyrus.article.domain.Document;
import papyrus.article.domain.repository.ArticleRepository;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void save(Message message) {
        articleRepository.save(message);
    }

    public List<ArticleResponse> findAllByCursor(Long cursorId, int limit) {
        return articleRepository.findAllByCursor(cursorId, limit)
                .stream()
                .map(ArticleResponse::from)
                .toList();
    }

}
