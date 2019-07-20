package com.danix.code.smell.example001;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

/**
 * @author danix
 */
final class Money {

  private final double amount;
  private final Currency currency;

  public static Money newEuro(final double amount) {
    return new Money(amount, Currency.EUR);
  }

  public static Money newInstance(final double amount, final Currency currency) {
    return new Money(amount, currency);
  }

  public double getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  @Nonnull
  public Money subtract(@Nonnull final Money money) {
    checkNotNull(money);
    if (!money.getCurrency().equals(currency)) {
      throw new RuntimeException("Can't subtract different currencies!");
    }
    return new Money(this.amount - money.amount, currency);
  }

  private Money(final double amount, final Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }
}
