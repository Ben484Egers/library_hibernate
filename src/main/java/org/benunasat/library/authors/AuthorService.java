package org.benunasat.library.authors;

import org.benunasat.library.config.JPAConfig;

import java.util.List;
import java.util.Optional;

public class AuthorService {

    private final AuthorDAO authorDAO;

    public AuthorService() {
        this.authorDAO = new AuthorDAO(JPAConfig.getEntityManager());
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorDAO.getAllAuthors().stream().map(AuthorMapper::entityToDTO).toList();
    }

    public AuthorDTO getAuthorByEmail(String email) {

        Optional<Author> optionalAuthor = authorDAO.findAuthorByEmail(email);

        if (optionalAuthor.isEmpty()) {
            throw new IllegalArgumentException("NO USER FOUND WITH ID");
        }

        return AuthorMapper.entityToDTO(optionalAuthor.get());
    }

    public AuthorDTO getAuthorById(Long id) {

        Optional<Author> optionalAuthor = authorDAO.findAuthorById(id);

        if (optionalAuthor.isEmpty()) {
            throw new IllegalArgumentException("NO AUTHOR FOUND WITH ID");
        }

        return AuthorMapper.entityToDTO(optionalAuthor.get());
    }

    public AuthorDTO updateAuthorInfo(AuthorDTO authorDTO) {
        Author updatedInfo = AuthorMapper.dtoToEntity(authorDTO);
        Author updatedAutor =  authorDAO.update(updatedInfo);

        return AuthorMapper.entityToDTO(updatedAutor);
    }


    public boolean deleteAuthor(Long id) {
        return authorDAO.deleteAuthor(id);
    }

}
