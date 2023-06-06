package papyrus.article.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import papyrus.article.domain.repository.ArticleRepository;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void save(Message message){ // enum 넣기 ?
        articleRepository.save(message);
    }
}
