package papyrus.article.presentation.aop;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
@Aspect
@RequiredArgsConstructor
public class RabbitListenerAspect {

    private final WebClient slackWebClient;

    @AfterThrowing(pointcut = "execution(* papyrus.article.presentation.RabbitmqConsumer.consumeMessage(..))", throwing = "exception")
    public void sendToSlack(JoinPoint joinPoint, Throwable exception) {
        String message = String.format("예외 발생 in %s. 예외 메시지: %s",
                joinPoint.getSignature().toString(), exception.getMessage());

        slackWebClient.post()
                .uri("/services/T052AJREX7E/B05A6FWV8UD/NeWI1aJGsp2Ha31DnvI8MjVp")
                .body(BodyInserters.fromValue(Map.of("text", message)))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
