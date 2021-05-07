package co.saimyr.bookstore.persistence;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.persistence.crud.CrudBookRepository;
import co.saimyr.bookstore.persistence.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookRepositoryImpl implements BookRepository {
    @Autowired
    private CrudBookRepository h2BookRepo;
    @Autowired
    private  BookMapper bookMapper;

    @Override
    public List<BookDomain> findAll() {
        return bookMapper.toBooks(h2BookRepo.findAllByOrderByNameAsc());
    }

    @Override
    public BookDomain findByIsbn(Integer isbn) {

        return bookMapper.toBook( h2BookRepo.findByIsbn(isbn));
    }

    @Override
    public List<BookDomain> findByAuthor(String author) {
        return bookMapper.toBooks(h2BookRepo.findByAuthorOrderByNameAsc(author));
    }

    @Override
    public List<BookDomain> findByPublisher(String publisher) {
        return bookMapper.toBooks(h2BookRepo.findByPublisherOrderByNameAsc(publisher));
    }

    @Override
    public BookDomain save(BookDomain b) {
        return bookMapper.toBook(h2BookRepo.save(bookMapper.toBookEntity(b)));
    }

    @Override
    public void delete(BookDomain b) {
        h2BookRepo.delete(bookMapper.toBookEntity(b));
    }

}
