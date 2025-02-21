package com.melvin.loans.service;

import com.melvin.loans.domain.Loan;
import com.melvin.loans.domain.LoanType;
import com.melvin.loans.dto.CustomerLoanRequest;
import com.melvin.loans.dto.CustomerLoanResponse;
import com.melvin.loans.dto.LoanResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

   public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest) {

      var customer = loanRequest.toCustomer();
      var loan = new Loan(customer);

      List<LoanResponse> loans = new ArrayList<>();

      if (loan.isPersonalLoanAvailable()) {
         loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
      }

      if (loan.isConsignedLoanAvailable()) {
         loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignedLoanInterestRate()));
      }

      if (loan.isGrantedLoanAvailable()) {
         loans.add(new LoanResponse(LoanType.GRANTED, loan.getGrantedLoanInterestRate()));
      }

      return new CustomerLoanResponse(loanRequest.name(), loans);
   }
}
