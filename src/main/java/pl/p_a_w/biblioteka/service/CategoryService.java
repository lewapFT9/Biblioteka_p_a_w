package pl.p_a_w.biblioteka.service;


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
}
