package com.danix.code.smell.example001;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

/**
 * @author danix
 */
class AccountReport {

  private final Account account;

  public AccountReport(@Nonnull final Account account) {
    this.account = checkNotNull(account);
  }

  public String printAccount() {
    return String.format("Account: IBAN: %s, Money: %.1f, Account type: %s", account.getIban(),
                         account.getMoneyAmount(), account.type);
  }

  public String printCustomer() {
    return String.format("%s %s", account.customer.name, account.customer.email);
  }

  public String printDaysOverdrawn() {
    return String.format("%s Account: IBAN: %s, Days Overdrawn: %s", account.customer.getFullName(),
                         account.getIban(), account.daysOverdrawn);
  }

  public String printMoney() {
    return String.format("%s Account: IBAN: %s, Money: %.1f", account.customer.getFullName(),
                         account.getIban(), account.getMoneyAmount());
  }
}
