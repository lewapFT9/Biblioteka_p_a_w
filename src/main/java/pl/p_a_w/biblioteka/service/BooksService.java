package pl.p_a_w.biblioteka.service;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.dto.BookDTO;
import pl.p_a_w.biblioteka.model.Ksiazki;
import pl.p_a_w.biblioteka.repo.BooksRepo;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

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
            Ksiazki book = booksRepo.findById(id).get();
            BookDTO bookDTO = new BookDTO(book.getId(),book.getTytul(),
                    book.getIdAutora().getImie()+" "+book.getIdAutora().getNazwisko(),
                    book.getIdKategorii().getNazwa(),book.getRokWydania(),book.getIloscEgzemplarzy());
            return ResponseEntity.ok(bookDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
