package com.danix.code.smell.example001;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

/**
 * @author danix
 */
public class Money {

  private final double amount;
  private final Currency currency;

  private Money(double amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public static Money newInstance(double amount, Currency currency) {
    return new Money(amount, currency);
  }

  public static Money newEuro(double amount) {
    return new Money(amount, Currency.EUR);
  }

  public double getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  @Nonnull
  public Money subtract(@Nonnull Money money) {
    checkNotNull(money);
    if (!money.getCurrency().equals(currency)) {
      throw new RuntimeException("Can't subtract different currencies!");
    }
    return new Money(this.amount - money.amount, currency);
  }
}
