package models.people;

import services.Data;

public class Customer extends Pessoa {
  boolean isCustomerValid = false;

  public Customer(String nome, String email, String telefone, int dia, int mes,int ano){  
    super(nome, email, telefone, dia, mes, ano);
    //TODO Auto-generated constructor stub
    this.isCustomerValid = checkCustomerValid(super.getDataNascimento());
  }

  public Customer(String nome, String email, String telefone) {
    this(nome, email, telefone, 0, 0, 0);
  }
  
  private boolean checkCustomerValid(Data dataNascimento){
    Data currentData = Data.getCurrentData();
    final int year = 365;
    int customerAgeInDays = dataNascimento.howManyDays(currentData);
    
    return customerAgeInDays/ year >= 18;
  }

}
