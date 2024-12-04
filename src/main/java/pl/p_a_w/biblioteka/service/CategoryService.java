package pl.p_a_w.biblioteka.service;


import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.dto.BookDTO;
import pl.p_a_w.biblioteka.model.Books;
import pl.p_a_w.biblioteka.model.Categories;
import pl.p_a_w.biblioteka.repo.BooksRepo;
import pl.p_a_w.biblioteka.repo.CategoryRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    final CategoryRepo categoryRepo;
    final BooksRepo booksRepo;

    public CategoryService(CategoryRepo categoryRepo, BooksRepo booksRepo) {
        this.categoryRepo = categoryRepo;
        this.booksRepo = booksRepo;
    }

    public ResponseEntity<Object> getAllCategories() {
        return ResponseEntity.ok(categoryRepo.findAll());
    }

    public ResponseEntity<Object> getBooksByCategory(int id) {
        if(booksRepo.findAllByCategory(id).isPresent()){
            List<BookDTO> books = new ArrayList<>();
            booksRepo.findAllByCategory(id).get()
                    .forEach(book -> {
                BookDTO bookDTO = new BookDTO(book.getId(), book.getTitle(),
                        book.getIdAuthor().getName()+" "+book.getIdAuthor().getSurname(),
                        book.getIdCategory().getName(),book.getReleaseYear(),book.getNumberOfCopies());
                    books.add(bookDTO);
                    });
            return ResponseEntity.ok(books);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Categories> returnCategoryToAddBook(String categoryName) {
        if(categoryRepo.findByName(categoryName).isPresent()){
            return ResponseEntity.ok(categoryRepo.findByName(categoryName).get());
        }
        Categories category = new Categories();
        category.setName(categoryName);
        categoryRepo.save(category);
        return ResponseEntity.ok(category);
    }

    public ResponseEntity<Object> addCategory(String categoryName) {
        if(categoryRepo.findByName(categoryName).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Categories category = new Categories();
        category.setName(categoryName);
        categoryRepo.save(category);
        return ResponseEntity.ok(category);
    }
    public ResponseEntity<Object> deleteCategory(int id) {
        if(categoryRepo.findById(id).isPresent()){
            categoryRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    public ResponseEntity<Object> updateCategory(int id, String categoryName) {
        if(categoryRepo.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Categories category = categoryRepo.findById(id).get();
        category.setName(categoryName);
        categoryRepo.save(category);
        return ResponseEntity.ok(category);
    }

    public ResponseEntity<Categories> findById(int id){
        if(categoryRepo.findById(id).isPresent()){
            return ResponseEntity.ok(categoryRepo.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
