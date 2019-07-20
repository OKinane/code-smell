package com.danix.code.smell.example001;

/**
 * @author danix
 */
class CustomerFactory {

  public Customer createCompany(final String name, final String email, final Account account,
                                final double companyOverdraftDiscount) {
    return new Company(name, email, account, companyOverdraftDiscount);
  }

  public Customer createPerson(final String name, final String surname, final String email, final Account account) {
    return new Person(name, surname, email, account);
  }
}
