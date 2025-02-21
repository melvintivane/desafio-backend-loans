package com.melvin.loans.domain;

import com.melvin.loans.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

   @Test
   void testEmptyConstructor() {
      assertDoesNotThrow(
           () -> new Customer(),
           "O construtor vazio não deveria lançar excepções."
      );
   }

   @Nested
   class IsIncomeEqualOrLowerThan {

      @Test
      void shouldBeTrueWhenIncomeIsEqual() {
         var customer = CustomerFactory.build(5000.00);

         assertTrue(
              customer.isIncomeEqualOrLowerThan(5000.00),
              "Deveria retornar true quando a renda é exatamente igual ao valor especificado."
         );
      }

      @Test
      void shouldBeTrueWhenIncomeIsLowerThan() {
         var customer = CustomerFactory.build(3000.00);

         assertTrue(
              customer.isIncomeEqualOrLowerThan(5000.00),
              "Deveria retornar true quando a renda é menor que o valor especificado."
         );
      }

      @Test
      void shouldBeFalseWhenIncomeIsGreaterThanValue() {
         var customer = CustomerFactory.build(5000.00);

         assertFalse(
              customer.isIncomeEqualOrLowerThan(3000.00),
              "Deveria retornar false quando a renda é maior que o valor especificado."
         );
      }
   }


   @Nested
   class IsIncomeEqualOrGreaterThan {

      @Test
      void shouldBeTrueWhenIncomeIsEqual() {
         var customer = CustomerFactory.build(5000.00);

         assertTrue(
              customer.isIncomeEqualOrGreaterThan(5000.00),
              "Deveria retornar true quando a renda é exatamente igual ao valor especificado."
         );
      }

      @Test
      void shouldBeTrueWhenIncomeIsGreaterThanValue() {
         var customer = CustomerFactory.build(5000.00);

         assertTrue(
              customer.isIncomeEqualOrGreaterThan(3000.00),
              "Deveria retornar true quando a renda é maior que o valor especificado."
         );
      }

      @Test
      void shouldBeFalseWhenIncomeIsLowerThanValue() {
         var customer = CustomerFactory.build(3000.00);

         assertFalse(
              customer.isIncomeEqualOrGreaterThan(5000.00),
              "Deveria retornar false quando a renda é menor que o valor especificado."
         );
      }
   }


   @Nested
   class isIncomeBetween {

      @Test
      void shouldBeTrueWhenIncomeIsBetween() {
         var customer = CustomerFactory.build(4000.00);

         assertTrue(
              customer.isIncomeBetween(3000.00, 5000.00),
              "Deveria retornar true para intervalo 3000-5000."
         );
      }

      @Test
      void shouldBeTrueWhenIncomeIsEqualToMin() {
         var customer = CustomerFactory.build(5000.0);

         assertTrue(
              customer.isIncomeBetween(5000.0, 8000.0),
              "Deveria retornar true quando min for igual à renda."
         );
      }

      @Test
      void shouldBeTrueWhenIncomeIsEqualToMax() {
         var customer = CustomerFactory.build(8000.0);

         assertTrue(
              customer.isIncomeBetween(5000.0, 8000.0),
              "Deveria retornar true quando max for igual à renda."
         );
      }

      @Test
      void shouldBeFalseWhenIncomeIsNotBetween() {
         var customer = CustomerFactory.build(7000.00);

         assertFalse(
              customer.isIncomeBetween(3000.00, 5000.00),
              "Deveria retornar false para intervalo 3000-5000."
         );
      }
   }

   @Nested
   class IsAgeLowerThan {

      @Test
      void shouldBeTrueWhenAgeIsLowerThanValue() {
         var customer = CustomerFactory.build(20);

         assertTrue(
              customer.isAgeLowerThan(30),
              "Deveria retornar true quando a idade for menor que o valor especificado."
         );
      }

      @Test
      void shouldBeFalseWhenAgeIsEqual() {
         var customer = CustomerFactory.build(30);

         assertFalse(
              customer.isAgeLowerThan(30),
              "Deveria retornar false quando a idade for exatamente igual ao valor especificado."
         );
      }

      @Test
      void shouldBeFalseWhenAgeIsGreaterThanValue() {
         var customer = CustomerFactory.build(30);

         assertFalse(
              customer.isAgeLowerThan(20),
              "Deveria retornar false quando a idade for maior que o valor especificado."
         );
      }
   }


   @Nested
   class IsFromLocation {

      @Test
      void shouldBeTrueWhenLocationIsTheSame() {
         var customer = CustomerFactory.build("Maputo");

         assertTrue(
              customer.isFromLocation("Maputo"),
              "Deveria retornar true quando a localização for exatamente a mesma."
         );
      }

      @Test
      void shouldBeFalseWhenLocationIsNotTheSame() {
         var customer = CustomerFactory.build("Maputo");

         assertFalse(
              customer.isFromLocation("Gaza"),
              "Deveria retornar false quando a localização for diferente da informada."
         );
      }
   }

}
