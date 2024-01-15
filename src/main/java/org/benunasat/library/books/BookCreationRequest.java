package org.benunasat.library.books;


import lombok.Builder;
import org.benunasat.library.authors.Author;
import org.benunasat.library.enums.Genre;
import org.benunasat.library.enums.Language;
import org.benunasat.library.series.Serie;

import java.time.LocalDate;
import java.util.List;


@Builder
public record BookCreationRequest(
                            String title,
                            String ISBN,
                            String description,
                            String image,
                            LocalDate releaseDate,
                            Genre genre,
                            Language language,
                            Serie serie,
                            List<Author> authors,
                            Integer copies,
                            Integer availableCopies
)
{}



