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

  public String getName() {
    return name;
  }

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

  public abstract String getFullName();

  protected abstract double getOverdraftFees(final Money money);

}
