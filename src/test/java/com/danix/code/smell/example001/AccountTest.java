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
    Account account = AccountTestUtils.getAccount(AccountType.normal, daysOverdrawn);
    double expectedBankCharge = BASE_BANKCHARGE + daysOverdrawn * 1.75;
    assertThat(account.bankCharge(), is(expectedBankCharge));
  }

  @Test
  public void testBankchargePremiumLessThanAWeek() {
    Account account = AccountTestUtils.getAccount(AccountType.premium, 5);
    assertThat(account.bankCharge(), is(14.5));
  }

  @Test
  public void testBankchargePremiumMoreThanAWeek() {
    Account account = AccountTestUtils.getAccount(AccountType.premium, 9);
    assertThat(account.bankCharge(), is(16.5));
  }

}
