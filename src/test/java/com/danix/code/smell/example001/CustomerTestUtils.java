package com.danix.code.smell.example001;

/**
 * @author danix
 */
class CustomerTestUtils {

  static final Customer person;
  static final Customer company;

  static {
    CustomerFactory customerFactory = new CustomerFactory();
    person = customerFactory.createPerson("danix", "dan", "dan@mail.com");
    company = customerFactory.createCompany("company", "company@mail.com", 0.50);
  }
}
