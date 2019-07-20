package com.danix.code.smell.example001;

/**
 * @author danix
 */
abstract class Customer {

  protected final Account account;
  private final String name;
  private final String email;

  protected Customer(final String name, final String email, final Account account) {
    this.name = name;
    this.email = email;
    this.account = account;
  }

  public String getEmail() {
    return email;
  }

  public abstract String getFullName();

  public String getName() {
    return name;
  }

  protected abstract double getOverdraftFees(final Money money);

  final public void withdraw(final Money money) {
    Money moneyToSubtract;
    if (account.isOverdraft()) {
      moneyToSubtract = Money.newInstance(money.getAmount() + getOverdraftFees(money),
                                          money.getCurrency());
    } else {
      moneyToSubtract = money;
    }
    account.subtract(moneyToSubtract);
  }

}
