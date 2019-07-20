package com.danix.code.smell.example001;

/**
 * @author danix
 */
class Company extends Customer {

  private final double companyOverdraftDiscount;

  public Company(final String name, final String email, final Account account,
                 final double companyOverdraftDiscount) {
    super(name, email, account);
    this.companyOverdraftDiscount = companyOverdraftDiscount;
  }

  @Override
  public String getFullName() {
    return getName();
  }

  protected double getOverdraftFees(final Money money) {
    int overdraftDiscountDivider = account.getType() == AccountType.premium ? 2 : 1;
    return money.getAmount() * account.overdraftFee() * companyOverdraftDiscount
        / overdraftDiscountDivider;
  }
}
