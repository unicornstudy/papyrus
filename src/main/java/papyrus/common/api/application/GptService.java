package papyrus.common.api.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import papyrus.common.api.chatGpt.ChatGptRequest;
import papyrus.common.api.chatGpt.ChatGptResponse;
import papyrus.common.api.koGpt.KoGptRequest;
import papyrus.common.api.koGpt.KoGptResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GptService {

    private final WebClient kakaoWebClient;

    private final WebClient gptWebClient;

    public Mono<KoGptResponse> summarizeByKoGpt(KoGptRequest koGptRequest) {
        return kakaoWebClient.post()
                .uri("/v1/inference/kogpt/generation")
                .bodyValue(koGptRequest)
                .retrieve()
                .bodyToMono(KoGptResponse.class);
    }

    public Mono<ChatGptResponse> summarizeByChatGpt(ChatGptRequest chatGptRequest) {
        return gptWebClient.post()
                .uri("/v1/chat/completions")
                .bodyValue(chatGptRequest)
                .retrieve()
                .bodyToMono(ChatGptResponse.class);
    }
}
