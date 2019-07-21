package com.danix.code.smell.example001;

/**
 * @author danix
 */
class Account {

  private static final double BASE_BANK_CHARGE = 4.5;
  public final AccountType type;
  public final int daysOverdrawn;
  private String iban;
  private Money money;

  public Account(final AccountType type, final Money money, final int daysOverdrawn) {
    super();
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

  public boolean isOverdraft() {
    return money.amount < 0;
  }

  public void subtract(final Money money) {
    this.money = this.money.subtract(money);
  }

  private double overdraftCharge() {
    if (type.isPremium()) {
      return 10 + Math.max(0, daysOverdrawn - 7);
    } else {
      return daysOverdrawn * 1.75;
    }
  }
}
