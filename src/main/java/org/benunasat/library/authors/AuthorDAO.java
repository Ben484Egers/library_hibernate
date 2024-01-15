package org.benunasat.library.authors;


import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class AuthorDAO {

    private final EntityManager entityManager;

    public AuthorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Author> getAllAuthors() {
        System.out.println("Getting all authors.....");
//        memberRepository.findAll().stream().map(AuthorMapper::entityToDTO).toList();
        return null;
    }
    public Author create(Author newAuthor) {
        System.out.println("Creating new user.....");
        return null;
    }
    public Author update(Author updatedAuthor) {
        System.out.println("Updating user.....");

        return null;
    }

    public boolean deleteAuthor (Long id) {
        System.out.println("Deleting author with id: " + id);
        return true;
    }

    public Optional<Author> findAuthorById(Long id) {
        System.out.println("Finding author by id.....");
        return Optional.of(null);
    }

    public Optional<Author> findAuthorByEmail (String email) {
        System.out.println("Finding author by email: "+ email);

        return Optional.empty();
    }

////    @Query("SELECT a FROM Author a WHERE a.firstName = ?1 AND a.lastName = ?2")
//    Optional<Author> findByName(String firstName, String lastName);


}
