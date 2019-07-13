package com.danix.code.smell.example001;

/**
 * @author danix
 */
class Account {

  private static final double BASE_BANK_CHARGE = 4.5;
  private final AccountType type;
  private final int daysOverdrawn;
  private String iban;
  private Money money;

  public Account(final AccountType type, final int daysOverdrawn) {
    super();
    this.type = type;
    this.daysOverdrawn = daysOverdrawn;
  }

  public double bankCharge() {
    return BASE_BANK_CHARGE + overdraftCharge();
  }

  public int getDaysOverdrawn() {
    return daysOverdrawn;
  }

  public String getIban() {
    return iban;
  }

  public void setIban(final String iban) {
    this.iban = iban;
  }

  public double getMoneyAmount() {
    return money.getAmount();
  }

  public AccountType getType() {
    return type;
  }

  public boolean isOverdraft() {
    return money.getAmount() < 0;
  }

  public double overdraftFee() {
    return type.isPremium() ? 0.10 : 0.20;
  }

  public void setMoney(final Money money) {
    this.money = money;
  }

  public void subtract(final Money money) {
    this.money = this.money.subtract(money);
  }

  private double overdraftCharge() {
    if (type.isPremium()) {
      return 10 + Math.max(0, getDaysOverdrawn() - 7);
    } else {
      return getDaysOverdrawn() * 1.75;
    }
  }
}
