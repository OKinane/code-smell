package com.danix.code.smell.example001;

import static com.danix.code.smell.example001.AccountTestUtils.getAccountByTypeAndMoney;
import static com.danix.code.smell.example001.CustomerTestUtils.getPersonCustomer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author danix
 */
public class PersonTest {

  private static final Money SOME_EURO = Money.newEuro(10);
  private final Customer personCustomer = getPersonCustomer();

  @Test
  public void testWithdrawPersonWithNormalAccount() {
    Account account = getAccountByTypeAndMoney(personCustomer, AccountType.normal, 34.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawPersonWithNormalAccountAndOverdraft() {
    Account account = getAccountByTypeAndMoney(personCustomer, AccountType.normal, -10.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-22.0));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccount() {
    Account account = getAccountByTypeAndMoney(personCustomer, AccountType.premium, 34.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccountAndOverdraft() {
    Account account = getAccountByTypeAndMoney(personCustomer, AccountType.premium, -10.0);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-21.0));
  }
}
