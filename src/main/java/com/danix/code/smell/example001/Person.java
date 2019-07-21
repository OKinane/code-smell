package com.danix.code.smell.example001;

/**
 * @author danix
 */
class Person extends Customer {

  private final String surname;

  public Person(final String name, final String surname, final String email) {
    super(name, email);
    this.surname = surname;
  }

  @Override
  public String getFullName() {
    return name + " " + surname;
  }

  @Override
  protected double getOverdraftFees(final AccountType accountType, final Money money) {
    return money.amount * accountType.overdraftFee();
  }
}
