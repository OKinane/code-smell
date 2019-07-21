package com.danix.code.smell.example001;

/**
 * @author danix
 */
class Person extends Customer {

  private final String surname;

  public Person(final String name, final String surname, final String email,
                final Account account) {
    super(name, email, account);
    this.surname = surname;
  }

  @Override
  public String getFullName() {
    return name + " " + surname;
  }

  @Override
  protected double getOverdraftFees(final Money money) {
    return money.amount * account.type.overdraftFee();
  }
}
