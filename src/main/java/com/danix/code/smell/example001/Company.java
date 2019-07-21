package com.danix.code.smell.example001;

/**
 * @author danix
 */
class Company extends Customer {

  private final double companyOverdraftDiscount;

  public Company(final String name, final String email, final double companyOverdraftDiscount) {
    super(name, email);
    this.companyOverdraftDiscount = companyOverdraftDiscount;
  }

  @Override
  public String getFullName() {
    return name;
  }

  @Override
  protected double getOverdraftFees(final AccountType accountType, final Money money) {
    int overdraftDiscountDivider = accountType.isPremium() ? 2 : 1;
    return money.amount * accountType.overdraftFee() * companyOverdraftDiscount
        / overdraftDiscountDivider;
  }
}
