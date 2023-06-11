package papyrus.article.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@org.springframework.data.elasticsearch.annotations.Document(indexName = "articles")
@Getter
public class Document extends Article{

    @Id
    private Long id;

    private String paragraphs;
}
