package co.saimyr.bookstore.domain.service;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.domain.dto.BookDTO;
import co.saimyr.bookstore.domain.mapper.BookDTOMapper;
import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.transversal.exception.BookStoreDomainException;
import co.saimyr.bookstore.transversal.exception.BookStoreException;
import co.saimyr.bookstore.transversal.exception.enumeration.TypeExceptionEnum;
import co.saimyr.bookstore.transversal.utilities.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookDTOMapper bookDTOMapper;

    public List<BookDTO> getAll() {
        return bookDTOMapper.toBooksDTO(bookRepository.findAll());
    }

    public List<BookDTO> getAllByPublisher(String publisher){
        if (StringUtil.isEmpty(publisher)){
            String userMessage ="The publisher can not be null or empty";
            throw BookStoreDomainException.CREATE(TypeExceptionEnum.BUSINESS,userMessage);
        }
        return bookDTOMapper.toBooksDTO(bookRepository.findByPublisher(publisher));

    }
    public List<BookDTO> getAllByAuthor(String author) {
        if(StringUtil.isEmpty(author)){
            String userMessage ="The author can not be null or empty";
            throw BookStoreDomainException.CREATE(TypeExceptionEnum.BUSINESS,userMessage);
        }
        return bookDTOMapper.toBooksDTO(bookRepository.findByAuthor(author));
    }
    public BookDTO newBook(BookDTO b) {
        if(bookRepository.findByName(b.getName())!= null){
            String userMessage ="The Book already exists";
            throw BookStoreDomainException.CREATE(TypeExceptionEnum.BUSINESS,userMessage);
        }
        return bookDTOMapper.toBookDTO(bookRepository.save(bookDTOMapper.toBookDomain(b)));
    }

    public void deleteBook(Integer isbn){
        BookDomain bookDomain = bookRepository.findByIsbn(isbn);
        if(bookDomain != null){
            bookRepository.delete(bookDomain);
        }else{
            String userMessage ="The Book does not exist";
            throw BookStoreDomainException.CREATE(TypeExceptionEnum.BUSINESS,userMessage);

        }
    }
}
