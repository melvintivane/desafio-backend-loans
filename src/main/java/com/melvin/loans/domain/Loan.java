package com.melvin.loans.domain;

public class Loan {

   private final Customer customer;

   public Loan(Customer customer) {
      this.customer = customer;
   }

   public boolean isPersonalLoanAvailable() {
      return isBasicLoanAvailable();
   }

   public boolean isGrantedLoanAvailable() {
      return  isBasicLoanAvailable();
   }

   public boolean isConsignedLoanAvailable() {
      return customer.isIncomeEqualOrGreaterThan(5000.00);
   }

   public double getPersonalLoanInterestRate() {
      if (isPersonalLoanAvailable()) {
         return 4.0;
      }

      throw new LoanNotAvailableException();
   }

   public double getGrantedLoanInterestRate() {
      if (isGrantedLoanAvailable()) {
         return 3.0;
      }

      throw new LoanNotAvailableException();
   }

   public double getConsignedLoanInterestRate() {
      if (isConsignedLoanAvailable()) {
         return 2.0;
      }

      throw new LoanNotAvailableException();
   }

   private boolean isBasicLoanAvailable() {
      if (customer.isIncomeEqualOrLowerThan(3000.00)) {
         return true;
      }

      return customer.isIncomeBetween(3000.00, 5000.00)
           && customer.isAgeLowerThan(30)
           && customer.isFromLocation("SP");
   }
}
