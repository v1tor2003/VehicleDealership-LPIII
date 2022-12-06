package models.people;

import services.Data;
import services.Services;

public class Customer extends Person {
  private String email;
  private String phone;
  private float salary;

  public Customer(String firstName, String lastName, int day, int month, int year, String email, String phone, float salary) {
    super(firstName, lastName, day, month, year);
    //TODO Auto-generated constructor stub
    if(Services.validateEmail(email))
      this.email = email;
    else
      this.email = new String ("Not valid");

    if(Services.validatePhoneNumber(phone))
      this.phone = phone;
    else
      this.phone = new String ("Not valid");
    
    if(validateCustomerSalary(salary))
      this.salary = salary;
    else
      this.salary = 1100;
  }

  public Customer(String firstName, String lastName, Data birthDate, String email, String phone, float salary){
    this(firstName, lastName, birthDate.getDia(),birthDate.getMes(), birthDate.getAno(), email, phone, salary);
  }

  public Customer(Person existingPerson, String email, String phone, float salary){
    this(existingPerson.getFirstName(),existingPerson.getLastName(), existingPerson.getBirthDate(),
        email, phone, salary);
  }
  
  private boolean validateCustomerSalary(float input){
    return input >= 0;
  }

  @Override
  public String toString(){
    return String.format("%sEmail: %s\nPhone: %s\nSalary: %.2f\n", super.toString()
                                  , this.email, this.phone, this.salary);
  }
}
