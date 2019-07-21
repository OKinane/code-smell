package com.danix.code.smell.example001;

import static com.danix.code.smell.example001.CustomerTestUtils.getAccount;
import static com.danix.code.smell.example001.CustomerTestUtils.getCompanyCustomer;
import static com.danix.code.smell.example001.CustomerTestUtils.getPersonCustomer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author dpersa
 */
public class AccountReportTest {

  @Test
  public void testPrintAccount_PersonCustomerNormalAccountType() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    AccountReport accountReport = new AccountReport(account);
    assertThat(accountReport.printAccount(),
               is("Account: IBAN: RO023INGB434321431241, Money: 34.0, Account type: normal"));
  }

  @Test
  public void testPrintAccount_PersonCustomerPremiumAccountTye() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.premium);
    AccountReport accountReport = new AccountReport(account);
    assertThat(accountReport.printAccount(),
               is("Account: IBAN: RO023INGB434321431241, Money: 34.0, Account type: premium"));
  }

  @Test
  public void testPrintCustomer_PersonCustomerNormalAccountType() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    AccountReport accountReport = new AccountReport(account);
    assertThat(accountReport.printCustomer(), is("danix dan@mail.com"));
  }

  @Test
  public void testPrintDaysOverdrawn_CompanyCustomerNormalAccountType() {
    Customer customer = getCompanyCustomer();
    Account account = getAccount(customer, AccountType.normal);
    AccountReport accountReport = new AccountReport(account);
    assertThat(accountReport.printDaysOverdrawn(),
               is("company Account: IBAN: RO023INGB434321431241, Days Overdrawn: 9"));
  }

  @Test
  public void testPrintDaysOverdrawn_PersonCustomerNormalAccountType() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    AccountReport accountReport = new AccountReport(account);
    assertThat(accountReport.printDaysOverdrawn(),
               is("danix dan Account: IBAN: RO023INGB434321431241, Days Overdrawn: 9"));
  }

  @Test
  public void testPrintMoney_CompanyCustomerNormalAccountType() {
    Customer customer = getCompanyCustomer();
    Account account = getAccount(customer, AccountType.normal);
    AccountReport accountReport = new AccountReport(account);
    assertThat(accountReport.printMoney(),
               is("company Account: IBAN: RO023INGB434321431241, Money: 34.0"));
  }

  @Test
  public void testPrintMoney_PersonCustomerNormalAccountType() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    AccountReport accountReport = new AccountReport(account);
    assertThat(accountReport.printMoney(),
               is("danix dan Account: IBAN: RO023INGB434321431241, Money: 34.0"));
  }
}
