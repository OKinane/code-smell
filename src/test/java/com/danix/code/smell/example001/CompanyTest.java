package com.danix.code.smell.example001;

import static com.danix.code.smell.example001.AccountTestUtils.getAccountByTypeAndMoney;
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
    Account account = getAccountByTypeAndMoney(companyCustomer, AccountType.normal, 34);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawCompanyWithNormalAccountAndOverdraft() {
    Account account = getAccountByTypeAndMoney(companyCustomer, AccountType.normal, -10);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-21.0));
  }

  @Test
  public void testWithdrawCompanyWithPremiumAccount() {
    Account account = getAccountByTypeAndMoney(companyCustomer, AccountType.premium, 34);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(24.0));
  }

  @Test
  public void testWithdrawCompanyWithPremiumAccountAndOverdraft() {
    Account account = getAccountByTypeAndMoney(companyCustomer, AccountType.premium, -10);
    account.withdraw(SOME_EURO);
    assertThat(account.getMoneyAmount(), is(-20.25));
  }
}
