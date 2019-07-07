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

  @Test
  public void testWithdrawPersonWithNormalAccount() {
    Account account = getAccountByTypeAndMoney(false, 34.0);
    Customer customer = getPersonCustomer(account);
    customer.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawPersonWithNormalAccountAndOverdraft() {
    Account account = getAccountByTypeAndMoney(false, -10.0);
    Customer customer = getPersonCustomer(account);
    customer.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-22.0));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccount() {
    Account account = getAccountByTypeAndMoney(true, 34.0);
    Customer customer = getPersonCustomer(account);
    customer.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccountAndOverdraft() {
    Account account = getAccountByTypeAndMoney(true, -10.0);
    Customer customer = getPersonCustomer(account);
    customer.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-21.0));
  }
}
