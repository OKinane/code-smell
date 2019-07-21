package com.danix.code.smell.example001;

/**
 * @author danix
 */
class Account {

  private static final double BASE_BANK_CHARGE = 4.5;
  public final AccountType type;
  public final int daysOverdrawn;
  public final Customer customer;
  private String iban;
  private Money money;

  public Account(final Customer customer, final AccountType type, final Money money,
                 final int daysOverdrawn) {
    super();
    this.customer = customer;
    this.type = type;
    this.money = money;
    this.daysOverdrawn = daysOverdrawn;
  }

  public double bankCharge() {
    return BASE_BANK_CHARGE + overdraftCharge();
  }

  public String getIban() {
    return iban;
  }

  public void setIban(final String iban) {
    this.iban = iban;
  }

  public double getMoneyAmount() {
    return money.amount;
  }

  final public void withdraw(final Money money) {
    Money moneyToSubtract;
    if (isOverdraft()) {
      moneyToSubtract = Money.newInstance(money.amount + customer.getOverdraftFees(type, money),
                                          money.currency);
    } else {
      moneyToSubtract = money;
    }
    this.money = this.money.subtract(moneyToSubtract);
  }

  private boolean isOverdraft() {
    return money.amount < 0;
  }

  private double overdraftCharge() {
    if (type.isPremium()) {
      return 10 + Math.max(0, daysOverdrawn - 7);
    } else {
      return daysOverdrawn * 1.75;
    }
  }
}
