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
public class CustomerReportTest {

  @Test
  public void testPrintCompanyCustomerDaysOverdrawn() {
    Customer customer = getCompanyCustomer();
    Account account = getAccount(customer, AccountType.normal);
    CustomerReport customerReport = new CustomerReport(customer, account);
    assertThat(customerReport.printCustomerDaysOverdrawn(),
               is("company Account: IBAN: RO023INGB434321431241, Days Overdrawn: 9"));
  }

  @Test
  public void testPrintCompanyCustomerMoney() {
    Customer customer = getCompanyCustomer();
    Account account = getAccount(customer, AccountType.normal);
    CustomerReport customerReport = new CustomerReport(customer, account);
    assertThat(customerReport.printCustomerMoney(),
               is("company Account: IBAN: RO023INGB434321431241, Money: 34.0"));
  }

  @Test
  public void testPrintCustomer() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    CustomerReport customerReport = new CustomerReport(customer, account);
    assertThat(customerReport.printCustomer(), is("danix dan@mail.com"));
  }

  @Test
  public void testPrintCustomerAccountNormal() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    CustomerReport customerReport = new CustomerReport(customer, account);
    assertThat(customerReport.printCustomerAccount(),
               is("Account: IBAN: RO023INGB434321431241, Money: 34.0, Account type: normal"));
  }

  @Test
  public void testPrintCustomerAccountPremium() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.premium);
    CustomerReport customerReport = new CustomerReport(customer, account);
    assertThat(customerReport.printCustomerAccount(),
               is("Account: IBAN: RO023INGB434321431241, Money: 34.0, Account type: premium"));
  }

  @Test
  public void testPrintCustomerDaysOverdrawn() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    CustomerReport customerReport = new CustomerReport(customer, account);
    assertThat(customerReport.printCustomerDaysOverdrawn(),
               is("danix dan Account: IBAN: RO023INGB434321431241, Days Overdrawn: 9"));
  }

  @Test
  public void testPrintCustomerMoney() {
    Customer customer = getPersonCustomer();
    Account account = getAccount(customer, AccountType.normal);
    CustomerReport customerReport = new CustomerReport(customer, account);
    assertThat(customerReport.printCustomerMoney(),
               is("danix dan Account: IBAN: RO023INGB434321431241, Money: 34.0"));
  }
}
