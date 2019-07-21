package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author danix
 */
public class MoneyTest {


  @Test
  public void testSubstract() {
    Money difference = Money.newEuro(20.0).subtract(Money.newEuro(10.0));
    Assert.assertThat(difference.amount, is(10.0));
    Assert.assertThat(difference.currency, is(Currency.EUR));
  }

  @Test(expected = RuntimeException.class)
  public void testSubstractDifferentCurrencies() {
    Money.newEuro(20.0).subtract(Money.newInstance(10.0, Currency.USD));
  }

  @Test
  public void testSubstractNegative() {
    Money difference = Money.newEuro(20.0).subtract(Money.newEuro(100.0));
    Assert.assertThat(difference.amount, is(-80.0));
    Assert.assertThat(difference.currency, is(Currency.EUR));
  }
}
