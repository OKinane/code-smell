package com.danix.code.smell.example001;

/**
 * @author danix
 */
class AccountTestUtils {

  static Account getAccount(final Customer customer, final AccountType accountType) {
    Account account = new Account(customer, accountType, Money.newEuro(34.0), 9);
    account.setIban("RO023INGB434321431241");
    return account;
  }

  static Account getAccountByTypeAndMoney(final Customer customer, final AccountType accountType,
                                          final double money) {
    Account account = new Account(customer, accountType, Money.newEuro(money), 9);
    account.setIban("RO023INGB434321431241");
    return account;
  }

  static Account getNormalAccount(final int daysOverdrawn) {
    AccountType premium = AccountType.normal;
    return new Account(CustomerTestUtils.person, premium, Money.newEuro(0), daysOverdrawn);
  }

  static Account getPremiumAccount(final int daysOverdrawn) {
    AccountType normal = AccountType.premium;
    return new Account(CustomerTestUtils.person, normal, Money.newEuro(0), daysOverdrawn);
  }
}
