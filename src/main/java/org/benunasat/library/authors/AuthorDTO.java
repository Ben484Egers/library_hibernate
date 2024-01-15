package org.benunasat.library.authors;

import lombok.Builder;

@Builder
public record AuthorDTO(Long id, String firstName, String lastName,String email, String imagePath){}

