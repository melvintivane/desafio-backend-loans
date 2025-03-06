package com.melvin.loans.domain;

public class Loan {

   private Customer customer;

   public Loan() {
   }

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
      if (customer.isIncomeEqualOrLessThan(3000.00)) {
         return true;
      }

      return customer.isIncomeBetween(3000.00, 5000.00)
           && customer.isAgeLowerThan(30)
           && customer.isFromLocation("SP");
   }
}
