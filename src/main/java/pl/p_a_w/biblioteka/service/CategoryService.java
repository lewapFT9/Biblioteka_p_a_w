package pl.p_a_w.biblioteka.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.repo.CategoryRepo;

@Service
public class CategoryService {

    final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public ResponseEntity<Object> getAllCategories() {
        return ResponseEntity.ok(categoryRepo.findAll());
    }
}
