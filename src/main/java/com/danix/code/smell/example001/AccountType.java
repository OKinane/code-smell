package com.danix.code.smell.example001;

/**
 * @author danix
 */
class AccountType {

  private final boolean premium;

  public AccountType(boolean premium) {
    this.premium = premium;
  }

  public boolean isPremium() {
    return premium;
  }

  @Override
  public String toString() {
    return premium ? "premium" : "normal";
  }
}
