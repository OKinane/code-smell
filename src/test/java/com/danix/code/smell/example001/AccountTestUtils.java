package com.danix.code.smell.example001;

/**
 * @author danix
 */
class AccountTestUtils {

  static Account getAccountByTypeAndMoney(final AccountType accountType, final double money) {
    Account account = new Account(accountType, Money.newEuro(money), 9);
    account.setIban("RO023INGB434321431241");
    return account;
  }
}
