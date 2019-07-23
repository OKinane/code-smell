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
    double accountMoney = 34.0;
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.normal, accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - SOME_EURO.amount;
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }

  @Test
  public void testWithdrawPersonWithNormalAccountAndOverdraft() {
    double accountMoney = -10.0;
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.normal, accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - (SOME_EURO.amount + SOME_EURO.amount * 0.20);
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccount() {
    double accountMoney = 34.0;
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.premium,
                                                  accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - SOME_EURO.amount;
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }

  @Test
  public void testWithdrawPersonWithPremiumAccountAndOverdraft() {
    double accountMoney = -10.0;
    Account account = AccountTestUtils.getAccount(personCustomer, AccountType.premium,
                                                  accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - (SOME_EURO.amount + SOME_EURO.amount * 0.10);
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }
}
