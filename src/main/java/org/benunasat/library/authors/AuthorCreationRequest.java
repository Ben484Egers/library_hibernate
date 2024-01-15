package org.benunasat.library.authors;

import lombok.Builder;

@Builder
public record AuthorCreationRequest(String firstName, String lastName, String imagePath, String email){}


