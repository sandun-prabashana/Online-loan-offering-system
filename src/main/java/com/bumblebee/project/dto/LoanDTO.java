package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanDTO {

    private Long loanId;

    @NotBlank(message = "Customer cannot be blank")
    private CustomerDTO customer;

    @NotBlank(message = "Loan Amount cannot be blank")
    private BigDecimal loanAmount;

    @NotBlank(message = "Loan Balance cannot be blank")
    private BigDecimal loanBalance;

    @NotBlank(message = "Installment Plan cannot be blank")
    private String installmentPlan;

    @NotBlank(message = "Status cannot be blank")
    private String status;
}
