package co.saimyr.bookstore.persistence.crud;

import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudBookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthorOrderByNameAsc(String author);
    List<BookEntity> findByPublisherOrderByNameAsc(String publisher);
    List<BookEntity> findAllByOrderByNameAsc();
    BookEntity findByIsbn(Integer isbn);
}
