package org.benunasat.library.loanReceipts;

import org.benunasat.library.books.BookDTO;
import org.benunasat.library.config.JPAConfig;

import java.util.List;
import java.util.Optional;

public class LoanReceiptService {

    private final LoanReceiptDAO loanReceiptDAO;

    public LoanReceiptService() {
        this.loanReceiptDAO = new LoanReceiptDAO(JPAConfig.getEntityManager());
    }

    public List<LoanReceipt> getAllLoanReceipts() {
        return loanReceiptDAO.getAllLoanReceipts();

    }

    public LoanReceipt createLoanReceipt(LoanReceipt loanReceipt) {
        return loanReceiptDAO.create(loanReceipt);

    }

    public LoanReceipt getLoanReceiptById(Long id) {

        Optional<LoanReceipt> optionalLoanReceipt = loanReceiptDAO.findLoanReceiptById(id);

        if (optionalLoanReceipt.isEmpty()) {
            throw new IllegalArgumentException("NO AUTHOR FOUND WITH ID");
        }

        return optionalLoanReceipt.get();
    }
    public List<LoanReceipt> findLoanReceiptsOfUser(Long userId) {

        List <LoanReceipt> receiptsOfUser = loanReceiptDAO.findLoanReceiptsofUser(userId);

        return receiptsOfUser;
    }

    public List<BookDTO> getTopLoanedBooks() {

        return loanReceiptDAO.getTopLoanedBooks();

    }

    public LoanReceipt updateLoanReceiptInfo(LoanReceipt loanReceipt) {

        LoanReceipt updatedLoanReceipt =  loanReceiptDAO.update(loanReceipt);

        return updatedLoanReceipt;
    }


    public boolean deleteLoanReceipt(Long id) {
        return loanReceiptDAO.deleteLoanReceipt(id);
    }

}
