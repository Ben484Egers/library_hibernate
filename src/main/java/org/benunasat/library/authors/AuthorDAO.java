package org.benunasat.library.authors;

import java.util.List;
import java.util.Optional;

public interface AuthorDAO {

    List<Author> getAllAuthors();

    Author create(Author newAuthor);

    Author update(Author updatedAuthor);

    boolean deleteAuthor (Long id);

    Optional<Author> findAuthorById(Long id);

    Optional<Author> findAuthorByEmail (String email);

}
