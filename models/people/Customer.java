package models.people;

import ds.singlyll.SinglyLinkedList;
import models.types.FinancingType;
import models.vehicles.Vehicle;
import services.Data;
import services.Financing;
import services.Services;

public class Customer extends Person {
  private String email;
  private String phone;
  private float salary;
  private SinglyLinkedList<Vehicle> ownedVehicles;

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

    ownedVehicles = new SinglyLinkedList<>();
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

  public void buyVehilce(Vehicle vehicle, FinancingType financing){
    System.out.printf("%s has purchased a %d %s\n", this.getFirstName(), vehicle.getFabYear(), vehicle.getModelName());
    formatSellingPriceDesc(vehicle.getPrice(), financing);
    this.ownedVehicles.insertAtEnd(vehicle);
  } 

  private String formatSellingPriceDesc(float price, FinancingType financing){
    String str = String.format("Total to be payed is $%.2f.\n", Financing.getPriceWithFinancing(price, financing));

    if(financing == FinancingType.NO_TAX)
      return str;  
    else
      str += String.format("%Entrance of $.2f, %sx of $.2f", Financing.getEntrance(price), 
                                                                    Financing.getInstallmentsPrice(price, financing),
                                                                    Financing.getInstallmentsQuantity(financing));
  
    return str;
  } 


  @Override
  public String toString(){
    return String.format("%sEmail: %s\nPhone: %s\nSalary: %.2f\n", super.toString()
                                  , this.email, this.phone, this.salary);
  }
}
