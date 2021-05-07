package co.saimyr.bookstore.transversal.exception;

import co.saimyr.bookstore.transversal.exception.enumeration.ComponentEnum;
import co.saimyr.bookstore.transversal.exception.enumeration.TypeExceptionEnum;

public class BookStoreDomainException extends BookStoreException {

    private static final long serialVersionUID = -4648180044709475179L;


    private BookStoreDomainException(TypeExceptionEnum type, String userText, Exception rootException) {
        super(type, userText, ComponentEnum.DOMAIN, rootException);
    }

    public static BookStoreException CREATE (TypeExceptionEnum type, String userText, Exception rootException){
        return  new BookStoreDomainException(type, userText, rootException);
    }

    public static BookStoreException CREATE (TypeExceptionEnum type, String userText){
        return new BookStoreDomainException(type, userText, new Exception(userText));
    }
}
