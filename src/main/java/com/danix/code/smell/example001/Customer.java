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

  public abstract void withdraw(final Money money);

}
