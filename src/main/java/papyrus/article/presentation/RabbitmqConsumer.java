package papyrus.article.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import papyrus.article.application.ArticleService;
import papyrus.article.infrastructure.rabbitmq.dto.Message;

@Component
@RequiredArgsConstructor
public class RabbitmqConsumer {

    private final ArticleService articleService;

    @RabbitListener(queues = "daum")
    public void consumeMessage(Message message) {
        articleService.save(message);
    }
}
