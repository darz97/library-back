package co.saimyr.bookstore.persistence.mapper;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mappings({
            @Mapping(source = "isbn", target = "isbn"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "author", target = "author"),
            @Mapping(source = "publisher", target = "publisher"),
            @Mapping(source = "genre", target = "genre")
    })
    BookDomain toBook(BookEntity bookEntity);
    List<BookDomain> toBooks(List<BookEntity> bookEntity);

    @InheritInverseConfiguration
    BookEntity toBookEntity(BookDomain bookDomain);
    List<BookEntity> toBooksEntity(List<BookDomain> bookDomain);

}
