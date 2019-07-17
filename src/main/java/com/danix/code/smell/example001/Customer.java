package com.danix.code.smell.example001;

/**
 * @author danix
 */
abstract class Customer {

  public final Account account;
  private final String name;
  private final String email;

  public Customer(final String name, final String email, final Account account) {
    this.name = name;
    this.email = email;
    this.account = account;
  }

  public String getEmail() {
    return email;
  }

  protected abstract String getFullName();

  public String getName() {
    return name;
  }

  public abstract void withdraw(Money money);

}
