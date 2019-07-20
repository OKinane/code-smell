package com.danix.code.smell.example001;

/**
 * @author danix
 */
class AccountTestUtils {

  static Account getAccountByTypeAndMoney(final AccountType accountType, final double money) {
    Account account = new Account(accountType, 9);
    account.setIban("RO023INGB434321431241");
    account.setMoney(Money.newEuro(money));
    return account;
  }
}
