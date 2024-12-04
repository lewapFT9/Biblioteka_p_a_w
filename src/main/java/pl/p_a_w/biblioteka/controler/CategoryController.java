package pl.p_a_w.biblioteka.controler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.p_a_w.biblioteka.model.Categories;
import pl.p_a_w.biblioteka.service.CategoryService;

import java.awt.print.Book;

@RestController
public class CategoryController {

    final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<Object> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}/books")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<Object> getBooksByCategory(@PathVariable int id) {
        return categoryService.getBooksByCategory(id);
    }

    @PostMapping("/admin/category/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> addCategory(@RequestBody String category) {
        return categoryService.addCategory(category);
    }

    @PatchMapping("/admin/category/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> updateCategory(@PathVariable int id, @RequestBody String category) {
        return categoryService.updateCategory(id, category);
    }
    @DeleteMapping("/admin/category/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }


}
