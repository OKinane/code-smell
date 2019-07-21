package com.danix.code.smell.example001;

/**
 * @author danix
 */
class CustomerFactory {

  public Customer createCompany(final String name, final String email,
                                final double companyOverdraftDiscount) {
    return new Company(name, email, companyOverdraftDiscount);
  }

  public Customer createPerson(final String name, final String surname, final String email) {
    return new Person(name, surname, email);
  }
}
