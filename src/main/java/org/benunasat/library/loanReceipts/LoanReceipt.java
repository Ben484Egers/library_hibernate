package org.benunasat.library.loanReceipts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.benunasat.library.books.Book;
import org.benunasat.library.users.User;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loan_receipt")
public class LoanReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate borrowDate;

    @Column
    private LocalDate returnDate;

    @Column(nullable = false)
    private LocalDate actualReturnDate;

    @Column(nullable = false)
    private LocalDate reserveDate;

    @Column(nullable = false)
    private String ticketNumber;
}

