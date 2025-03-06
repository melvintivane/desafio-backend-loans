package com.melvin.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
public class LoanTest {

   @Mock
   private Customer customer;

   @InjectMocks
   private Loan loan;

   @Test
   void testEmptyConstructor() {
      assertDoesNotThrow(
           () -> new Loan(),
           "O construtor vazio não deveria lançar excepções."
      );
   }

   @Nested
   class isPersonalLoanAvailable {

      @Test
      void shouldBeAvailableWhenIncomeIsEqualOrLessThan3k() {
         doReturn(true).when(customer).isIncomeEqualOrLessThan(3000.0);

         assertTrue(loan.isPersonalLoanAvailable());
      }

      @Test
      void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {
         doReturn(false).when(customer).isIncomeEqualOrLessThan(3000.0);
         doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
         doReturn(true).when(customer).isAgeLowerThan(30);
         doReturn(true).when(customer).isFromLocation("SP");

         assertTrue(loan.isPersonalLoanAvailable());
      }

      @Test
      void shouldNotBeAvailableWhenIncomeIsBetween3000And5000AndAgeIsLessThan30ButLocationIsNotSP() {
         doReturn(false).when(customer).isIncomeEqualOrLessThan(3000.0);
         doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
         doReturn(true).when(customer).isAgeLowerThan(30);
         doReturn(false).when(customer).isFromLocation("SP");

         assertFalse(loan.isPersonalLoanAvailable());
      }

      @Test
      void shouldNotBeAvailableWhenIncomeIsGreaterThan5000() {
         doReturn(false).when(customer).isIncomeEqualOrLessThan(3000.0);
         doReturn(false).when(customer).isIncomeBetween(3000.0, 5000.0);

         assertFalse(loan.isPersonalLoanAvailable());
      }
   }

   @Nested
   class isGrantedLoanAvailable {

      @Test
      void shouldBeAvailableWhenIncomeIsEqualOrLess3k() {

      }
   }
}
