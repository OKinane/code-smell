package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author danix
 */
public class PersonTest {

  private static final Money SOME_EURO = Money.newEuro(10);
  private final Customer personCustomer = CustomerTestUtils.person;

  @Test
  public void testWithdrawPersonWithNormalAccount() {
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.normal, 34.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawPersonWithNormalAccountAndOverdraft() {
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.normal, -10.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-22.0));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccount() {
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.premium, 34.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccountAndOverdraft() {
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.premium, -10.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-21.0));
  }
}
