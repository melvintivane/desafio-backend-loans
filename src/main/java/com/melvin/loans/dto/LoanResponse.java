package com.melvin.loans.dto;

import com.melvin.loans.domain.LoanType;

public record LoanResponse(LoanType loanType, Double interestRate) {
}
