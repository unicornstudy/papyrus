package papyrus.article.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import papyrus.article.application.ArticleService;
import papyrus.article.application.dto.ArticleResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getArticles(@RequestParam(required = false) Long cursorId, @RequestParam(defaultValue = "10") int limit) {
        return new ResponseEntity<>(articleService.findAllByCursor(cursorId, limit), HttpStatus.OK);
    }

}
