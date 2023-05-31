package papyrus.common.api.koGpt;

import lombok.Getter;

import java.util.List;

@Getter
public class KoGptResponse {
    private String id;
    private List<KoGptGeneration> generations;
    private KoGptUsage usage;
}
