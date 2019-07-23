package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author danix
 */
public class CompanyTest {

  private static final Money SOME_EURO = Money.newEuro(10);
  private final Customer companyCustomer = CustomerTestUtils.company;

  @Test
  public void testWithdrawCompanyWithNormalAccount() {
    int accountMoney = 34;
    Account account = AccountTestUtils.getAccount(companyCustomer, AccountType.normal,
                                                  accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - SOME_EURO.amount;
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }

  @Test
  public void testWithdrawCompanyWithNormalAccountAndOverdraft() {
    int accountMoney = -10;
    Account account = AccountTestUtils.getAccount(companyCustomer, AccountType.normal,
                                                  accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - (SOME_EURO.amount + SOME_EURO.amount * 0.20 * 0.50);
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }

  @Test
  public void testWithdrawCompanyWithPremiumAccount() {
    int accountMoney = 34;
    Account account = AccountTestUtils.getAccount(companyCustomer, AccountType.premium,
                                                  accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - SOME_EURO.amount;
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }

  @Test
  public void testWithdrawCompanyWithPremiumAccountAndOverdraft() {
    int accountMoney = -10;
    Account account = AccountTestUtils.getAccount(companyCustomer, AccountType.premium,
                                                  accountMoney);
    account.withdraw(SOME_EURO);
    double expectedAmount = accountMoney - (SOME_EURO.amount + SOME_EURO.amount * 0.10 * 0.50 / 2);
    assertThat(account.getMoneyAmount(), is(expectedAmount));
  }
}
