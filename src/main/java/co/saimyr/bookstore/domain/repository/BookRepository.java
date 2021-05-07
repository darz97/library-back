package co.saimyr.bookstore.domain.repository;

import co.saimyr.bookstore.domain.BookDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<BookDomain> findAll();
    BookDomain findByIsbn(Integer isbn);
    List<BookDomain> findByAuthor(String author);
    List<BookDomain> findByPublisher(String publisher);
    BookDomain save(BookDomain b);
    BookDomain findByName(String name);
    void delete(BookDomain b);
}
