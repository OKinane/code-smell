package com.danix.code.smell.example001;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

/**
 * @author danix
 */
final class Money {

  public final double amount;
  public final Currency currency;

  public static Money newEuro(final double amount) {
    return new Money(amount, Currency.EUR);
  }

  public static Money newInstance(final double amount, final Currency currency) {
    return new Money(amount, currency);
  }

  @Nonnull
  public Money subtract(@Nonnull final Money money) {
    checkNotNull(money);
    if (!money.currency.equals(currency)) {
      throw new RuntimeException("Can't subtract different currencies!");
    }
    return new Money(this.amount - money.amount, currency);
  }

  private Money(final double amount, final Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }
}
