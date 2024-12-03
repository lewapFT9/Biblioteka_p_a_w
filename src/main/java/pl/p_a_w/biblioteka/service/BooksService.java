package pl.p_a_w.biblioteka.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.dto.BookDTO;
import pl.p_a_w.biblioteka.model.Books;
import pl.p_a_w.biblioteka.repo.BooksRepo;

@Service
public class BooksService {

    final
    BooksRepo booksRepo;

    public BooksService(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
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


}
