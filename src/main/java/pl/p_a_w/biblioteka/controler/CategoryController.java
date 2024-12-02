package pl.p_a_w.biblioteka.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.p_a_w.biblioteka.service.CategoryService;

@RestController
public class CategoryController {

    final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<Object> getCategories() {
        return categoryService.getAllCategories();
    }
}
