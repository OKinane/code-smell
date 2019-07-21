package com.danix.code.smell.example001;

/**
 * @author danix
 */
abstract class Customer {

  public final String name;
  public final String email;
  protected final Account account;

  protected Customer(final String name, final String email, final Account account) {
    this.name = name;
    this.email = email;
    this.account = account;
  }

  final public void withdraw(final Money money) {
    Money moneyToSubtract;
    if (account.isOverdraft()) {
      moneyToSubtract = Money.newInstance(money.amount + getOverdraftFees(money), money.currency);
    } else {
      moneyToSubtract = money;
    }
    account.subtract(moneyToSubtract);
  }

  public abstract String getFullName();

  protected abstract double getOverdraftFees(final Money money);

}
