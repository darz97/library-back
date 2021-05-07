package co.saimyr.bookstore.transversal.exception;


import co.saimyr.bookstore.transversal.exception.enumeration.ComponentEnum;
import co.saimyr.bookstore.transversal.exception.enumeration.TypeExceptionEnum;

public class BookStoreException extends BaseException {


    private static final long serialVersionUID = -4532859420364634021L;

    protected BookStoreException(TypeExceptionEnum type, String userText, ComponentEnum component, Exception rootException) {
        super(type, userText, component, rootException);
    }
}
