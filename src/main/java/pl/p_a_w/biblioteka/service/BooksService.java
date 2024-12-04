package pl.p_a_w.biblioteka.service;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.dto.BookDTO;
import pl.p_a_w.biblioteka.dto.BookDTO2;
import pl.p_a_w.biblioteka.model.Authors;
import pl.p_a_w.biblioteka.model.Books;
import pl.p_a_w.biblioteka.repo.AuthorRepo;
import pl.p_a_w.biblioteka.repo.BooksRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BooksService {

    final
    BooksRepo booksRepo;
    final
    AuthorRepo authorRepo;
    final
    AuthorService authorService;
    final
    CategoryService categoryService;

    public BooksService(BooksRepo booksRepo, AuthorRepo authorRepo, AuthorService authorService, CategoryService categoryService) {
        this.booksRepo = booksRepo;
        this.authorRepo = authorRepo;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }
    public ResponseEntity<Object> getBooks() {
        return ResponseEntity.ok(booksRepo.findAll());
    }

    public ResponseEntity<Object> getBook(int id) {
        if(booksRepo.findById(id).isPresent()) {
            Books book = booksRepo.findById(id).get();
            BookDTO bookDTO = new BookDTO(book.getId(),book.getTitle(),
                    book.getIdAuthor().getName()+" "+book.getIdAuthor().getSurname(),
                    book.getIdCategory().getName(),book.getReleaseYear(),book.getNumberOfCopies());
            return ResponseEntity.ok(bookDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Object> getBooksByAuthor(String author) {
        if(authorRepo.findByFirstName(author).isPresent()){
            List<Integer> authors_id = authorService.findAuthorByName(author).getBody();
            System.out.println(authors_id);
            List<Books> books = new ArrayList<>();
            assert authors_id != null;
            for (Integer authorId : authors_id) {
                List<Books> booksByAuthor = booksRepo.findByAuthor(authorId);
                books.addAll(booksByAuthor);
            }
            return ResponseEntity.ok(books);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Books> addBook(@Valid BookDTO2 dto) {
        BookDTO2 bookDTO =new BookDTO2(dto.getTitle(),dto.getCategory(),
                dto.getYearOfRelease(), dto.getNumberOfCopies(), dto.getAuthorName(), dto.getAuthorSurname());
        Books book = new Books();
        book.setTitle(bookDTO.getTitle());
        book.setReleaseYear(bookDTO.getYearOfRelease());
        book.setNumberOfCopies(bookDTO.getNumberOfCopies());
        book.setIdAuthor(authorService.returnAuthorToAddBook(bookDTO.getAuthorName(), bookDTO.getAuthorSurname()).getBody());
        book.setIdCategory(categoryService.returnCategoryToAddBook(bookDTO.getCategory()).getBody());
        return ResponseEntity.ok(booksRepo.save(book));
    }


}
