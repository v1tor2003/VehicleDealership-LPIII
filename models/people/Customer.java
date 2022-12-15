package models.people;

import ds.singlyll.SinglyLinkedList;
import models.types.FinancingType;
import models.vehicles.Vehicle;
import services.Data;
import services.Financing;
import services.Services;

public class Customer extends Person implements Comparable<Customer>{
  private String email;
  private String phone;
  private SinglyLinkedList<Vehicle> ownedVehicles;

  public Customer(String firstName, String lastName, String cpf,int day, int month, int year, String email, String phone) {
    super(firstName, lastName,cpf, day, month, year);
    //TODO Auto-generated constructor stub
    if(Services.validateEmail(email))
      this.email = email;
    else
      this.email = new String ("Not valid");

    if(Services.validatePhoneNumber(phone))
      this.phone = phone;
    else
      this.phone = new String ("Not valid");
      
    ownedVehicles = new SinglyLinkedList<>();
  }

  public Customer(String firstName, String lastName, String cpf, Data birthDate, String email, String phone){
    this(firstName, lastName, cpf,birthDate.getDia(),birthDate.getMes(), birthDate.getAno(), email, phone);
  }

  public Customer(Person existingPerson, String email, String phone){
    this(existingPerson.getFirstName(),existingPerson.getLastName(), existingPerson.getCPF(),existingPerson.getBirthDate(),
        email, phone);
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

  private int getOwnedVehiclesQuantity(){
    return this.ownedVehicles.size();
  }

  @Override
  public String toString(){
    return String.format("%sEmail: %s\nPhone: %s\n", super.toString()
                                  , this.email, this.phone,this.getOwnedVehiclesQuantity());
  }

  
  @Override
  public int compareTo(Customer obj){
    if(obj.getFullName().compareTo(this.getFullName())==0){
      return 0;
    }
    else if(obj.getFullName().compareTo(this.getFullName())==1){
      return -1;
    }
    else 
    {
      return 1;
    }
  }
  private boolean equalsLocal(Customer obj)
  {
    return compareTo(obj)==0;
  }

  @Override
  public boolean equals(Object obj)
  {
    return equalsLocal((Customer)obj);
  }


}

