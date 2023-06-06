package papyrus.article.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@org.springframework.data.elasticsearch.annotations.Document(indexName = "articles")
public class Document extends Article{

    @Id
    private Long id;

    private String paragraphs;
}