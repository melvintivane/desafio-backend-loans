package com.melvin.loans.factory;

import com.melvin.loans.domain.Customer;

public class CustomerFactory {

   public static Customer build() {
      return new Customer(25, "275.484.389-23", "Vuxaywua Zukiagou", 7000.00, "SP");
   }

   public static Customer build(int age) {
      return new Customer(age, "275.484.389-23", "Vuxaywua Zukiagou", 7000.00, "SP");
   }

   public static Customer build(String location) {
      return new Customer(26, "275.484.389-23", "Vuxaywua Zukiagou", 7000.00, location);
   }

   public static Customer build(Double income) {
      return new Customer(25, "275.484.389-23", "Vuxaywua Zukiagou", income, "SP");
   }
}
