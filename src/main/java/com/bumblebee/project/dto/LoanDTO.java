package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanDTO {

    private Long loanId;

    private CustomerDTO customer;

    private BigDecimal loanAmount;

    private BigDecimal loanBalance;

    private String installmentPlan;
}
