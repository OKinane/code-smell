package com.danix.code.smell.example001;

/**
 * @author danix
 */
enum AccountType {
  premium, normal;

  public boolean isPremium() {
    return this == premium;
  }

  public double overdraftFee() {
    return isPremium() ? 0.10 : 0.20;
  }
}
