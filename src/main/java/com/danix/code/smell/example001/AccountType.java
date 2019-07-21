package com.danix.code.smell.example001;

/**
 * @author danix
 */
enum AccountType {
  premium, normal;

  public double overdraftFee() {
    return this == AccountType.premium ? 0.10 : 0.20;
  }
}
