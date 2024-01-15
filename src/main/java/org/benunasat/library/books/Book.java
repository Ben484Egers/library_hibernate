package org.benunasat.library.books;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.benunasat.library.authors.Author;
import org.benunasat.library.enums.Genre;
import org.benunasat.library.enums.Language;
import org.benunasat.library.series.Serie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String ISBN;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable=false)
    private Integer copies;

    @Column(nullable=false)
    private Integer availableCopies;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie series;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(name = "book_author",
            joinColumns = { @JoinColumn(name = "book_id", referencedColumnName = "id")  },
            inverseJoinColumns = { @JoinColumn(name = "author_id", referencedColumnName = "id")} )
    private List<Author> authors = new ArrayList<>();


}



