package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AccountTypeTest {


  @Test
  public void testOverdraftFeeNotPremium() {
    AccountType accountType = AccountType.normal;
    assertThat(accountType.overdraftFee(), is(0.20));
  }

  @Test
  public void testOverdraftFeePremium() {
    AccountType accountType = AccountType.premium;
    assertThat(accountType.overdraftFee(), is(0.10));
  }
}
