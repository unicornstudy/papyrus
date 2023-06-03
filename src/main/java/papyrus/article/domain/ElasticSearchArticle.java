package papyrus.article.domain;

import jakarta.persistence.Id;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "articles")
public class ElasticSearchArticle {

    @Id
    private Long id;

    private String title;

    private String reporter;

    private String category;

    private String press;

    private List<String> paragraphs;
}
