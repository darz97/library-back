package co.saimyr.bookstore.domain.mapper;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.domain.dto.BookDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookDTOMapper {
    @Mappings({
            @Mapping(source = "isbn", target = "isbn"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "author", target = "author"),
            @Mapping(source = "publisher", target = "publisher"),
            @Mapping(source = "genre", target = "genre")
    })
    BookDTO toBookDTO(BookDomain bookDomain);
    List<BookDTO> toBooksDTO(List<BookDomain> bookDomains);

    @InheritInverseConfiguration
    BookDomain toBookDomain(BookDTO bookDTO);
    List<BookDomain> toBooksDomain(List<BookDTO> bookDTOS);
}
