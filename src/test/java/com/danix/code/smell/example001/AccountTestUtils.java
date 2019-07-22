package com.danix.code.smell.example001;

/**
 * @author danix
 */
class AccountTestUtils {

  static Account getAccount(final Customer customer, final AccountType accountType,
                            final double money) {
    return getAccount(customer, accountType, money, 0);
  }

  static Account getAccount(final AccountType accountType, final int daysOverdrawn) {
    return getAccount(CustomerTestUtils.person, accountType, 0, daysOverdrawn);
  }

  static Account getAccountWithIban(final Customer customer, final AccountType accountType,
                                    final double money) {
    Account account = getAccount(customer, accountType, money, 9);
    account.setIban("RO023INGB434321431241");
    return account;
  }

  private static Account getAccount(final Customer customer, final AccountType accountType,
                                    final double money, final int daysOverdrawn) {
    return new Account(customer, accountType, Money.newEuro(money), daysOverdrawn);
  }

}
