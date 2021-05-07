package co.saimyr.bookstore.web;

import co.saimyr.bookstore.domain.dto.BookDTO;
import co.saimyr.bookstore.domain.service.BookService;
import co.saimyr.bookstore.transversal.enumeration.ResponseStateEnum;
import co.saimyr.bookstore.transversal.exception.BookStoreException;
import co.saimyr.bookstore.transversal.utilities.ObjectUtil;
import co.saimyr.bookstore.transversal.utilities.StringUtil;
import co.saimyr.bookstore.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse<BookDTO>> getAll() {
        ApiResponse<BookDTO> response = new ApiResponse<>();
        ResponseEntity<ApiResponse<BookDTO>> requestResponse;
        List<String> messages = new ArrayList<>();
        try {
            List<BookDTO> bookDTOS = bookService.getAll();
            if(bookDTOS.isEmpty()){
                 messages.add("There are no books to show at the moment.");
                response.setMessage(messages);
            }else{
                messages.add("The books has been successfully listed.");
                response.setMessage(messages);
            }
            response.setMessage(messages);
            response.setState(ResponseStateEnum.SUCCESS);
            response.setData(bookDTOS);
            requestResponse = new ResponseEntity<>(response, HttpStatus.OK);

        }catch (BookStoreException exception){
            messages.add(exception.getUserText());
            response.setMessage(messages);
            response.setState(ResponseStateEnum.ERROR);
            requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return requestResponse;
    }

    @GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse<BookDTO>>  getByAuthor(@PathVariable("author") String author) {
        ApiResponse<BookDTO> response = new ApiResponse<>();
        ResponseEntity<ApiResponse<BookDTO>> requestResponse;
        List<String> messages = new ArrayList<>();
        boolean validBook = true;
        try {
            if(StringUtil.isEmpty(author)){
                messages.add("The author can not be null or empty.");
                response.setMessage(messages);
            }
            if(validBook){
                List<BookDTO> bookDTOS = bookService.getAllByAuthor(author);
                if (bookDTOS.isEmpty()){
                    messages.add("There are no books with the given author.");
                    response.setMessage(messages);
                }else{
                    messages.add("The books has been found.");
                    response.setMessage(messages);
                }
                response.setMessage(messages);
                response.setState(ResponseStateEnum.SUCCESS);
                response.setData(bookDTOS);
                requestResponse = new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.setState(ResponseStateEnum.ERROR);
                requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (BookStoreException exception){
            messages.add(exception.getUserText());
            response.setMessage(messages);
            response.setState(ResponseStateEnum.ERROR);
            requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return requestResponse;

    }
    @GetMapping(value = "/publisher/{publisher}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse<BookDTO>>  getByPublisher(@PathVariable("publisher") String publisher) {
        ApiResponse<BookDTO> response = new ApiResponse<>();
        ResponseEntity<ApiResponse<BookDTO>> requestResponse;
        List<String> messages = new ArrayList<>();
        boolean validBook = true;
        try {
            if(StringUtil.isEmpty(publisher)){
                messages.add("The publisher can not be null or empty.");
                response.setMessage(messages);
            }
            if(validBook){
                List<BookDTO> bookDTOS = bookService.getAllByPublisher(publisher);
                if (bookDTOS.isEmpty()){
                    messages.add("There are no books with the given publisher.");
                    response.setMessage(messages);
                }else{
                    messages.add("The books has been found.");
                    response.setMessage(messages);
                }
                response.setMessage(messages);
                response.setState(ResponseStateEnum.SUCCESS);
                response.setData(bookDTOS);
                requestResponse = new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.setState(ResponseStateEnum.ERROR);
                requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (BookStoreException exception){
            messages.add(exception.getUserText());
            response.setMessage(messages);
            response.setState(ResponseStateEnum.ERROR);
            requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return requestResponse;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse<BookDTO >> newBook(@RequestBody BookDTO book) {
        ApiResponse<BookDTO> response = new ApiResponse<>();
        ResponseEntity<ApiResponse<BookDTO>> requestResponse;
        List<String> messages = new ArrayList<>();
        List<BookDTO> bookDTOS = new ArrayList<>();
        boolean validBook = true;
        try {
            if(ObjectUtil.objectIsNull(book)){
                messages.add("The book can not be null");
                response.setMessage(messages);
            }
            if(validBook){
                BookDTO bookDTO = bookService.newBook(book);
                bookDTOS.add(bookDTO);

                messages.add("The books has been successfully create.");
                response.setMessage(messages);
                response.setData(bookDTOS);
                response.setState(ResponseStateEnum.SUCCESS);
                requestResponse = new ResponseEntity<>(response, HttpStatus.CREATED);
            }else{
                response.setState(ResponseStateEnum.ERROR);
                requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        }catch (BookStoreException exception){
            messages.add(exception.getUserText());
            response.setMessage(messages);
            response.setState(ResponseStateEnum.ERROR);
            requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return requestResponse;
    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<ApiResponse<BookDTO>> delete(@PathVariable("isbn")int isbn){
        ApiResponse<BookDTO> response = new ApiResponse<>();
        ResponseEntity<ApiResponse<BookDTO>> requestResponse;
        List<String> messages = new ArrayList<>();
        boolean validBook = true;
        try {
            if(validBook){
                bookService.deleteBook(isbn);
                messages.add("The book has been successfully delete.");
                response.setMessage(messages);
                response.setData((new ArrayList<>()));
                response.setState(ResponseStateEnum.SUCCESS);
                requestResponse = new ResponseEntity<>(response, HttpStatus.CREATED);
            }else{
                messages.add("the book could not be deleted.");
                response.setMessage(messages);
                response.setState(ResponseStateEnum.ERROR);
                requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        }catch (BookStoreException exception){
            messages.add(exception.getUserText());
            response.setMessage(messages);
            response.setState(ResponseStateEnum.ERROR);
            requestResponse = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return requestResponse;
    }
}
