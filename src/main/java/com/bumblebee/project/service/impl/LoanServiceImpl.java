package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.LoanDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.model.Loan;
import com.bumblebee.project.repository.LoanRepository;
import com.bumblebee.project.service.LoanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Loan createLoan(LoanDTO loanDTO) {
        Loan loan = modelMapper.map(loanDTO, Loan.class);
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new AdminNotFoundException("Loan not found with id: " + loanId));
    }

    @Override
    public Loan updateLoan(Long loanId, Loan loan2) {
        Loan loan = getLoanById(loanId);
        loan.setCustomer(loan2.getCustomer());
        loan.setInstallmentPlan(loan2.getInstallmentPlan());
        loan.setLoanAmount(loan2.getLoanAmount());
        loan.setLoanBalance(loan2.getLoanBalance());
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(Long loanId) {
        Loan loan = getLoanById(loanId);
        loanRepository.delete(loan);
    }

    @Override
    public List<Loan> getAllLoan() {
        return loanRepository.findAll();
    }
}
