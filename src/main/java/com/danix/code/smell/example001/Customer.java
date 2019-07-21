package com.danix.code.smell.example001;

/**
 * @author danix
 */
abstract class Customer {

  public final String name;
  public final String email;

  protected Customer(final String name, final String email) {
    this.name = name;
    this.email = email;
  }

  public abstract String getFullName();

  protected abstract double getOverdraftFees(final AccountType accountType, final Money money);

}
