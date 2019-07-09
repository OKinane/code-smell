package com.danix.code.smell.example001;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

/**
 * @author danix
 */
class CustomerReport {

  private final Customer customer;
  private final Account account;

  public CustomerReport(@Nonnull final Customer customer, @Nonnull final Account account) {
    this.customer = checkNotNull(customer);
    this.account = checkNotNull(account);
  }

  public String printCustomerDaysOverdrawn() {
    return String.format("%sAccount: IBAN: %s, Days Overdrawn: %s",
        customer.getFullName(), account.getIban(), account.getDaysOverdrawn());
  }

  public String printCustomerMoney() {
    return String.format("%sAccount: IBAN: %s, Money: %.1f",
        customer.getFullName(), account.getIban(), account.getMoneyAmount());
  }

  public String printCustomerAccount() {
    return String.format("Account: IBAN: %s, Money: %.1f, Account type: %s",
        account.getIban(), account.getMoneyAmount(), account.getType());
  }

  public String printCustomer() {
    return String.format("%s %s",
        customer.getName(), customer.getEmail());
  }
}
