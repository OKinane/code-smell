package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class Company extends Customer {

  private final double companyOverdraftDiscount;

  Company(final String name, final String email, final Account account,
          final double companyOverdraftDiscount) {
    super(name, email, account);
    this.companyOverdraftDiscount = companyOverdraftDiscount;
  }

  @Override
  protected String getFullName() {
    return name;
  }

  @Override
  public void withdraw(final Money money) {
    Money moneyToSubtract;
    if (account.isOverdraft()) {
      moneyToSubtract = Money.newInstance(money.getAmount() + getOverdraftFees(money),
                                          money.getCurrency());
    } else {
      moneyToSubtract = money;
    }
    account.subtract(moneyToSubtract);
  }

  private double getOverdraftFees(final Money money) {
    int overdraftDiscountDivider = account.getType().isPremium() ? 2 : 1;
    return money.getAmount() * account.overdraftFee() * companyOverdraftDiscount
        / overdraftDiscountDivider;
  }
}
