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
    return name;
  }

  @Override
  protected double getOverdraftFees(final Money money) {
    int overdraftDiscountDivider = account.type == AccountType.premium ? 2 : 1;
    return money.amount * account.type.overdraftFee() * companyOverdraftDiscount
        / overdraftDiscountDivider;
  }
}
