package com.bumblebee.project.controller;


import com.bumblebee.project.dto.LoanDTO;
import com.bumblebee.project.model.Loan;
import com.bumblebee.project.service.LoanService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/loan")
public class loanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createAdmin(@Valid @RequestBody LoanDTO loanDTO) throws MessagingException {
        Loan loan = loanService.createLoan(loanDTO);
        return new ResponseEntity(new StandardResponse("200", "Loan Register successfully", loan), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getAdminById(@PathVariable Long loanId) {
        Loan loan = loanService.getLoanById(loanId);
        return new ResponseEntity(new StandardResponse("200", "Loan retrieved successfully", loan), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateAdmin(@PathVariable Long loanId, @RequestBody Loan loan2) {
        Loan loan = loanService.updateLoan(loanId, loan2);
        return new ResponseEntity(new StandardResponse("200", "Loan updated successfully", loan), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long loanId) {
        loanService.deleteLoan(loanId);
        return new ResponseEntity(new StandardResponse("200", "Loan deleted successfully", loanId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllAdmins() {
        List<Loan> loan = loanService.getAllLoan();
        return new ResponseEntity(new StandardResponse("200", "Loan retrieved successfully", loan), HttpStatus.OK);
    }

}
