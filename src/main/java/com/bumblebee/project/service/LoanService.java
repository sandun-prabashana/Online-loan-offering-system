package com.bumblebee.project.service;


import com.bumblebee.project.dto.LoanDTO;
import com.bumblebee.project.model.Loan;

import java.util.List;

public interface LoanService {
    Loan createLoan(LoanDTO loanDTO);
    Loan getLoanById(Long productId);
    Loan updateLoan(Long productId, Loan loan);
    void deleteLoan(Long productId);
    List<Loan> getAllLoan();
}
