package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author danix
 */
public class AccountTest {

  private static final double BASE_BANKCHARGE = 4.5;

  @Test
  public void testBankchargeNormal() {
    int daysOverdrawn = 10;
    Account account = getNormalAccount(daysOverdrawn);
    double expectedBankCharge = BASE_BANKCHARGE + daysOverdrawn * 1.75;
    assertThat(account.bankCharge(), is(expectedBankCharge));
  }

  @Test
  public void testBankchargePremiumLessThanAWeek() {
    Account account = getPremiumAccount(5);
    assertThat(account.bankCharge(), is(14.5));
  }

  @Test
  public void testBankchargePremiumMoreThanAWeek() {
    Account account = getPremiumAccount(9);
    assertThat(account.bankCharge(), is(16.5));
  }

  @Test
  public void testOverdraftFeePremium() {
    Account account = getPremiumAccount(9);
    assertThat(account.overdraftFee(), is(0.10));
  }

  @Test
  public void testOverdraftFeeNotPremium() {
    Account account = getNormalAccount(0);
    assertThat(account.overdraftFee(), is(0.20));
  }

  private Account getNormalAccount(final int daysOverdrawn) {
    AccountType premium = new AccountType(false);
    return new Account(premium, daysOverdrawn);
  }

  private Account getPremiumAccount(final int daysOverdrawn) {
    AccountType normal = new AccountType(true);
    return new Account(normal, daysOverdrawn);
  }
}
