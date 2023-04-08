package com.bumblebee.project;


import com.bumblebee.project.model.Brand;
import com.bumblebee.project.model.Customer;
import com.bumblebee.project.model.Loan;
import com.bumblebee.project.model.User;
import com.bumblebee.project.repository.BrandRepository;
import com.bumblebee.project.repository.CustomerRepository;
import com.bumblebee.project.repository.LoanRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoanRepositoryTest {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveLoanTest(){
        Customer customer = customerRepository.findById((long) 16).get();
        Loan loan = Loan.builder()
                .customer(customer)
                .loanAmount(BigDecimal.valueOf(15000))
                .loanBalance(BigDecimal.valueOf(15000))
                .installmentPlan("3")
                .status("ACTIVE")
                .build();
        loanRepository.save(loan);
        Assertions.assertThat(loan.getLoanId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getLoanTest(){
        Loan loan = loanRepository.findById(1L).get();
        Assertions.assertThat(loan.getLoanId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfLoansTest(){
        List<Loan> loans = loanRepository.findAll();
        Assertions.assertThat(loans.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateLoanTest(){
        Loan loan = loanRepository.findById(1L).get();
        loan.setInstallmentPlan("2");
        Loan loanUpdated =  loanRepository.save(loan);
        Assertions.assertThat(loanUpdated.getInstallmentPlan()).isEqualTo("2");

    }


}