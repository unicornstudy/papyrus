package papyrus.article.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import papyrus.article.application.ArticleService;
import papyrus.article.application.dto.ArticleResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAll(@RequestParam(required = false) Long cursorId, @RequestParam(defaultValue = "10") int limit) {
        return new ResponseEntity<>(articleService.findAllByCursor(cursorId, limit), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> summarize(@PathVariable Long id) {
        return new ResponseEntity<>(articleService.getSummary(id), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ArticleResponse>> findByTitleAndParagraphs(@RequestParam String word) {
        return new ResponseEntity<>(articleService.findAllByParagraphsContainingOrTitleContaining(word), HttpStatus.OK);
    }
}
