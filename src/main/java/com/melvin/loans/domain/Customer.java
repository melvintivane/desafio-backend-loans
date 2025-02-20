package com.melvin.loans.domain;

public class Customer {

   private Integer age;
   private String cpf;
   private String name;
   private Double income;
   private String location;

   public Customer() {
   }

   public Customer(Integer age, String cpf, String name, Double income, String location) {
      this.age = age;
      this.cpf = cpf;
      this.name = name;
      this.income = income;
      this.location = location;
   }

   public boolean isIncomeEqualOrLowerThan(Double value) {
      return income <= value;
   }

   public boolean isIncomeEqualOrGreaterThan(Double value) {
      return income >= value;
   }

   public boolean isIncomeBetween(Double min, Double max) {
      return income >= min && income <= max;
   }

   public boolean isAgeLowerThan(int value) {
      return age < value;
   }

   public boolean isFromLocation(String value) {
      return location.equalsIgnoreCase(value);
   }

}
