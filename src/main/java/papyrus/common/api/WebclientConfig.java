package papyrus.common.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientConfig {

    @Bean
    public WebClient kakaoWebClient(@Value("${kakao-base-url}") String baseUrl, @Value("${kakao-api-key}") String key) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("Authorization", "KakaoAK " + key);
                    httpHeaders.set("Content-type", "application/json");
                })
                .build();
    }

    @Bean
    public WebClient gptWebClient(@Value("${gpt-base-url}") String baseUrl, @Value("${gpt-api-key}") String key) {
        return WebClient.builder()
                .baseUrl((baseUrl))
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("Authorization", "Bearer " + key);
                    httpHeaders.set("Content-Type", "application/json");
                })
                .build();
    }
}
