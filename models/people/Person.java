package models.people;

import services.Data;
import services.Services;

public class Person{
  private String firstName;
  private String lastName;
  private int age;
  private Data birthDate;

  public Person(String firstName, String lastName, int dia, int mes, int ano){
    if(Services.validateRandName(firstName))
      this.firstName = firstName;
    if(Services.validateRandName(firstName))
      this.lastName = lastName;

    this.birthDate = new Data(dia, mes, ano);
    age = getPersonAge(birthDate);
  }
  
  public Person(String firstName, String lastName, Data birthDate){
    this(firstName, lastName, birthDate.getDia(), birthDate.getMes(), birthDate.getAno());
  }

  private String getFullName(){
    return this.getFirstName() + " " + this.getLastName();
  }

  protected String getFirstName(){
    return this.firstName;
  }

  protected String getLastName(){
    return this.lastName;
  }

  protected Data getBirthDate(){
    return this.birthDate;
  }

  private int getPersonAge(Data birhDate){
    Data curData = Data.getCurrentData();
    final int yearDefaultSize = 365;
    final int daysSinceBirth = birhDate.howManyDays(curData);

    return daysSinceBirth / yearDefaultSize;
  }

  public int getAge(){
    return this.age;
  }

  public String toString(){
    return String.format("Name: %s\nBorn in: %s\n", this.getFullName(), this.birthDate);
  }
}