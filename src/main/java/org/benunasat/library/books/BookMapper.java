package org.benunasat.library.books;

public class BookMapper {
    public static BookDTO entityToDTO(Book book) {
        return BookDTO.builder().
                id(book.getId()).
                title(book.getTitle()).
                ISBN(book.getISBN()).
                description(book.getDescription()).
                image(book.getImage()).
                releaseDate(book.getReleaseDate()).
                genre(book.getGenre()).
                language(book.getLanguage()).
                authors(book.getAuthors()).
                serie(book.getSeries()).
                copies(book.getCopies()).
                availableCopies(book.getAvailableCopies()).
                build();
    }

    public static Book dtoToEntity(BookCreationRequest bookDTOCreate) {
        return Book.builder()
                .title(bookDTOCreate.title())
                .ISBN(bookDTOCreate.ISBN())
                .description(bookDTOCreate.description())
                .image(bookDTOCreate.image())
                .releaseDate(bookDTOCreate.releaseDate())
                .genre(bookDTOCreate.genre())
                .language(bookDTOCreate.language())
                .authors(bookDTOCreate.authors())
                .series(bookDTOCreate.serie())
                .copies(bookDTOCreate.copies())
                .availableCopies(bookDTOCreate.availableCopies()).build();

    }

    public static Book dtoToEntity(BookDTO bookDTO) {
        return Book.builder()
                .title(bookDTO.title())
                .ISBN(bookDTO.ISBN())
                .description(bookDTO.description())
                .image(bookDTO.image())
                .releaseDate(bookDTO.releaseDate())
                .genre(bookDTO.genre())
                .language(bookDTO.language())
                .authors(bookDTO.authors())
                .series(bookDTO.serie())
                .copies(bookDTO.copies())
                .availableCopies(bookDTO.availableCopies()).build();

    }
}

