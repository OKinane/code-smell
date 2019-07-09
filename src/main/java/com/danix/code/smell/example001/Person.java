package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class Person extends Customer {

  private final String surname;

  Person(final String name, final String surname, final String email, final Account account) {
    super(name, email, account);
    this.surname = surname;
  }

  @Override
  public void withdraw(final Money money) {
    if (account.isOverdraft()) {
      double overdraftFees = money.getAmount() * account.overdraftFee();
      account.subtract(
          Money.newInstance(money.getAmount() + overdraftFees,
              money.getCurrency()));
    } else {
      account.subtract(Money.newInstance(money.getAmount(), money.getCurrency()));
    }
  }

  @Override
  protected String getFullName() {
    return name + " " + surname;
  }
}
