package com.danix.code.smell.example001;

/**
 * @author danix
 */
public abstract class Customer {

  final String name;
  final Account account;
  private final String email;

  Customer(final String name, final String email, final Account account) {
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
