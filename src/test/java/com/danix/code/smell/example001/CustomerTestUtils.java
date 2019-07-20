package com.danix.code.smell.example001;

/**
 * @author danix
 */
class CustomerTestUtils {

  private static final CustomerFactory customerFactory = new CustomerFactory();

  static Account getAccount(final AccountType accountType) {
    Account account = new Account(accountType, Money.newEuro(34.0), 9);
    account.setIban("RO023INGB434321431241");
    return account;
  }

  static Customer getCompanyCustomer(final Account account) {
    return customerFactory.createCompany("company", "company@mail.com", account, 0.50);
  }

  static Customer getPersonCustomer(final Account account) {
    return customerFactory.createPerson("danix", "dan", "dan@mail.com", account);
  }
}
