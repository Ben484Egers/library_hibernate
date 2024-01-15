package org.benunasat.library.books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.benunasat.library.enums.Genre;
import org.benunasat.library.enums.Language;
import org.benunasat.library.series.Serie;

import java.util.List;
import java.util.Optional;

public class BookDAO {

    private final EntityManager entityManager;


    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Book> getAllBooks() {
        System.out.println("Getting all books.....");
        String query = "select b from Book b";
        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        System.out.println(typedQuery.getResultList());
        return typedQuery.getResultList();
    }
    public Book create(Book newBook) {
        System.out.println("Creating new book.....");
        Book bookReturn = null;
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(newBook);
            entityManager.getTransaction().commit();
            bookReturn = newBook;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return bookReturn;
    }
    public Book update(Book updatedBook) {
        System.out.println("Updating book.....");

        return null;
    }

    public boolean deleteBook (Long id) {
        System.out.println("Deleting book with id: " + id);
        return true;
    }

    public Optional<Book> findBookById(Long id) {
        System.out.println("Finding book by id.....");
        return Optional.of(null);
    }

    public Optional<Book> findBookByISBN (String ISBN) {
        System.out.println("Finding author by ISBN: "+ ISBN);

        return Optional.empty();
    }


//    @Query("select b from Book b where b.series.id = ?1")
    public List<Book> findBooksBySerieId(Long id){
        return null;
    }

    //    @Query("Select b from Book b where b.language = ?1 and b.genre = ?2")
    public List<Book> findBooksByLanguage(Language language){
        return null;
    }

//    @Query("Select b from Book b where b.genre = ?1")
    public List<Book> findBooksByGenre(Genre genre){
        return null;
    }

//    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.firstName LIKE %?1% or a.lastName LIKE %?1% or b.title LIKE %?1%")
    public List<Book> findBookByAuthorAndTitleContaining(String searchTerm){
        return null;
    }


}
