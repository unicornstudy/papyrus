package papyrus.article.infrastructure.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import papyrus.article.domain.ElasticSearchArticle;
import papyrus.article.domain.PostgreArticle;
import papyrus.article.domain.repository.ElasticSearchArticleRepository;
import papyrus.article.domain.repository.PostgreArticleRepository;
import papyrus.article.infrastructure.rabbitmq.dto.RabbitmqMessage;

@Component
@RequiredArgsConstructor
public class RabbitmqConsumer {

    private final ElasticSearchArticleRepository elasticSearchArticleRepository;
    private final PostgreArticleRepository postgreArticleRepository;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Transactional
    @RabbitListener(queues = "daum")
    public void consumeMessage(RabbitmqMessage message) {
        ElasticSearchArticle esArticle = message.toElasticSearchArticle();
        PostgreArticle pgArticle = message.toPostgreArticle();

        postgreArticleRepository.save(pgArticle);
        elasticSearchArticleRepository.save(esArticle);
    }
}
