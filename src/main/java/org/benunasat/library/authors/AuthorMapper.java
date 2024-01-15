package org.benunasat.library.authors;

public class AuthorMapper {

    public static Author dtoToEntity(AuthorCreationRequest newAuthor) {
        return Author.builder()
                .firstName(newAuthor.firstName())
                .lastName(newAuthor.lastName())
                .imagePath(newAuthor.imagePath())
                .email(newAuthor.email())
                .build();
    }

    public static AuthorDTO entityToDTO(Author author) {
        return  AuthorDTO.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .email(author.getEmail())
                .imagePath(author.getImagePath())
                .build();
    }
    public static Author dtoToEntity(AuthorDTO authorDTO) {
        return  Author.builder()
                .id(authorDTO.id())
                .firstName(authorDTO.firstName())
                .lastName(authorDTO.lastName())
                .email(authorDTO.email())
                .imagePath(authorDTO.imagePath())
                .build();
    }
}

