package papyrus.article.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import papyrus.article.application.dto.ArticleResponse;
import papyrus.article.domain.Document;
import papyrus.article.domain.repository.ArticleRepository;
import papyrus.article.infrastructure.rabbitmq.dto.Message;
import papyrus.common.api.application.GptService;
import papyrus.common.api.chatGpt.ChatGptRequest;
import papyrus.common.api.koGpt.KoGptRequest;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final GptService gptService;
    private final RedisTemplate<Long, String> redisTemplate;

    @Transactional
    public void save(Message message) {
        articleRepository.save(message);
    }

    public List<ArticleResponse> findAllByCursor(Long cursorId, int limit) {
        return articleRepository.findAllByCursor(cursorId, limit)
                .stream()
                .map(ArticleResponse :: from)
                .toList();
    }

    public String getSummary(Long id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(id))
                .orElseGet(() -> {
                    Document document = articleRepository.findById(id).orElseThrow();
                    String summary = gptService.summarizeByChatGpt(ChatGptRequest.of(document.getParagraphs()))
                            .map(response -> response.getParagraphs())
                            .onErrorResume(e -> gptService.summarizeByKoGpt(KoGptRequest.of(document.getParagraphs()))
                                    .map(response -> response.getParagraphs()))
                            .block();
                    redisTemplate.opsForValue().set(id, summary);
                    return summary;
                });
    }

    public List<ArticleResponse> findAllByParagraphsContainingOrTitleContaining(String word) {
        return articleRepository.findAllByParagraphsContainingOrTitleContaining(word)
                .stream()
                .map(ArticleResponse :: from)
                .toList();
    }


}
