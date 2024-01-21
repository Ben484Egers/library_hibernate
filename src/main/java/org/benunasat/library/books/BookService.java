package org.benunasat.library.books;

import org.benunasat.library.config.JPAConfig;
import org.benunasat.library.enums.Genre;
import org.benunasat.library.enums.Language;

import java.util.List;
import java.util.Optional;

public class BookService {

    private final BookDAO bookDAO;


    public BookService() {
        this.bookDAO = new BookDAO(JPAConfig.getEntityManager());
    }

    public List<BookDTO> getAllBooks() {
        return bookDAO.getAllBooks().stream().map(BookMapper::entityToDTO).toList();
    }

    public BookDTO getBookById(Long id) {

        Optional<Book> optionalBook = bookDAO.findBookById(id);

        if (optionalBook.isEmpty()) {
            throw new IllegalArgumentException("NO AUTHOR FOUND WITH ID");
        }

        return BookMapper.entityToDTO(optionalBook.get());
    }
    public List<BookDTO> findBooksBySerieId(Long id) {

        List <Book> booksOfSerie = bookDAO.findBooksBySerieId(id);

        return booksOfSerie.stream().map(BookMapper::entityToDTO).toList();
    }
    public List<BookDTO> findBooksByGenre(Genre genre) {

        List <Book> booksOfGenre = bookDAO.findBooksByGenre(genre);

        return booksOfGenre.stream().map(BookMapper::entityToDTO).toList();
    }
    public List<BookDTO> findBooksByLanguage(Language language) {

        List <Book> booksOfLanguage = bookDAO.findBooksByLanguage(language);

        return booksOfLanguage.stream().map(BookMapper::entityToDTO).toList();
    }
    public List<BookDTO> searchBooksByTitleAndAuthor(String searchTerm) {

        List <Book> matchingBooks = bookDAO.findBookByAuthorAndTitleContaining(searchTerm);

        return matchingBooks.stream().map(BookMapper::entityToDTO).toList();
    }

    public BookDTO updateBookInfo(BookDTO bookDTO) {
        Book updatedInfo = BookMapper.dtoToEntity(bookDTO);
        Book updatedBook =  bookDAO.update(updatedInfo);

        return BookMapper.entityToDTO(updatedBook);
    }


    public boolean deleteBook(Long id) {
        return bookDAO.deleteBook(id);
    }

}
