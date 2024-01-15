package org.benunasat.library.loanReceipts;

import jakarta.persistence.EntityManager;
import org.benunasat.library.books.BookDTO;

import java.util.List;
import java.util.Optional;

public class LoanReceiptDAO {

    private final EntityManager entityManager;

    public LoanReceiptDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<LoanReceipt> getAllLoanReceipts() {
        System.out.println("Getting all receipts.....");
//        memberRepository.findAll().stream().map(LoanReceiptMapper::entityToDTO).toList();
        return null;
    }
    public LoanReceipt create(LoanReceipt newLoanReceipt) {
        System.out.println("Creating new receipt.....");
        return null;
    }
    public LoanReceipt update(LoanReceipt updatedLoanReceipt) {
        System.out.println("Updating book.....");

        return null;
    }

    public boolean deleteLoanReceipt (Long id) {
        System.out.println("Deleting book with id: " + id);
        return true;
    }

    public Optional<LoanReceipt> findLoanReceiptById(Long id) {
        System.out.println("Finding receipt by id.....");
        return Optional.of(null);
    }

    public List<LoanReceipt> findLoanReceiptsofUser(Long userId) {
        System.out.println("Finding receipts of user: "+ userId);

        return null;
    }


    public List<BookDTO> getTopLoanedBooks() {
        return null;
    }

//    @Query("select l from LibraryTicket l GROUP BY l.book.id, l.id ORDER BY COUNT(l.book.id) DESC")
//    List<LibraryTicket> findTopLoanReceipts(Pageable pageable);


}
