package main.components;

import java.util.Scanner;



import ds.tree.Tree;
import models.people.Customer;
import services.Data;
import services.Services;
public class CustomerRecords{   
  private static Tree <Customer> records;
  private static Scanner keyboardInput=new Scanner(System.in);
  private static String userInput;

  public CustomerRecords(){
    records=new Tree<>();
  }

  
   public void add(){
    //Customer customerToAdd= fillCustomerCredentials();
    int i=0;
    Customer c1 = new Customer("pedro", "affonso", "3", 10,11,2002,"pasmarques@gmail.com", "7381191894");
    Customer c2 = new Customer("pedro", "affonso", "0", 10,11,2001,"pasmarques@gmail.com", "7381191894");
    Customer[] vet= new Customer[2];
    vet[0]=c1;
    vet[1]=c2;
    

    while(i<2){
      if(!records.contaisKey(records.getRoot(),vet[i].getCPF())){
        records.insertBT(records.getRoot(),vet[i]);
      }
      else{
        System.out.println("You cannot duplicate a Customer, Try again");
        break;
      }
      i++;
    }
  }
  
  /*
   * public void add(){
    Customer customerToAdd= fillCustomerCredentials();
    if(!records.contains(records.getRoot(),customerToAdd)){
      if(records.findKey(records.getRoot(),customerToAdd.getAge()))
        records.insertBT(records.getRoot(),customerToAdd);
    }
    else{
      System.out.println("You cannot duplicate a Customer, Try again");
    }
  }
   */
  public void remove(Customer customer){
    if(records.contains(records.getRoot(),customer))
      records.removeBT(customer);
    else{
      System.out.println("There is no such record.");
    }
  }

  public Customer fillCustomerCredentials(){
    String firstName;
    String lastName;
    String cpfInput;
    int dayInput;
    int monthInput; 
    int yearInput;
    String emailInput;
    String phoneInput;

    System.out.println("Type your first name: ");
    firstName= keyboardInput.nextLine();
    //keyboardInput.close();

    System.out.println("Type your last name: ");
    lastName = keyboardInput.nextLine();
    //keyboardInput.close();

    System.out.println("Type your cpf: ");
    cpfInput = keyboardInput.nextLine();
    //keyboardInput.close();

    System.out.println("Type the day you was born: ");
    dayInput= keyboardInput.nextInt();
    //keyboardInput.close();

    System.out.println("Type the month you was born: ");
    monthInput= keyboardInput.nextInt();
    //keyboardInput.close();

    System.out.println("Type the year you was born: ");
    yearInput= keyboardInput.nextInt();
    //keyboardInput.close();

    System.out.println("Type your email: ");
    emailInput= keyboardInput.nextLine();
    //keyboardInput.close();

    System.out.println("Type your cell phone number: ");
    phoneInput= keyboardInput.nextLine();
    //keyboardInput.close();
    keyboardInput.close();
    return new Customer(firstName, lastName, cpfInput, dayInput, monthInput, yearInput, emailInput, phoneInput);

  }

  public void showCustomers(){
    records.printTree(records.getRoot());
  }

 /*
  *  public Customer fillCustomer(){
    String name;
    String cpfInput;
    Data bornDate;
    String emailInput;
    String phoneInput;
    name=fillUserNameInput();
    cpfInput=validateCpfandPhoneNumberInput()[0];
    bornDate=validateDate();
  
    //return new Customer(firstName, lastName, cpfInput, dayInput, monthInput, yearInput, emailInput, phoneInput);
  }
  */
   /*
  private String fillUserNameInput(){

    System.out.println("Type your name in format: FirstName + LastName");

    userInput= keyboardInput.nextLine();

    String firstName = userInput.substring(0, userInput.indexOf(" "));
    String lastName= userInput.substring(userInput.indexOf(" ") + 1);

    if(Services.validateRandName(firstName)&&Services.validateRandName(lastName)){
    return firstName+lastName;
    }
    return null;
  }

  private String[] fillCpfandPhoneNumberInput(){
    final String arrayCpfAndNumber[] = new String[2];

    System.out.println("Type your cpf: ");
    userInput=keyboardInput.nextLine();

    while(Services.validateCPF(userInput)){
      System.out.println("Invalid cpf, try again typing in format ###.###.###.##, without dots");
      System.out.println("Type your cpf again: ");
      //keyboardInput.close();
      userInput=keyboardInput.nextLine();
    }
    arrayCpfAndNumber[0]=userInput;

    System.out.println("Type your phone number: ");
    userInput=keyboardInput.nextLine();

    while(Services.validatePhoneNumber(userInput)){
    System.out.println("Invalid phone number, try again typing in format ##-#######, without -");
    System.out.println("Type your phone number again: ");
    //keyboardInput.close();
    userInput=keyboardInput.nextLine();
    }
    arrayCpfAndNumber[1]=userInput;
    return arrayCpfAndNumber;
  }
  public void showCustomers(){
    records.printTree(records.getRoot());
  }

  private int[] arrayBornDate(){
    final int bornDateArray[]=new int[3];

    System.out.println("Type your born date in format DD/MM/YYYY: ");
    userInput=keyboardInput.nextLine();
    bornDateArray[0]= Integer.parseInt(userInput.substring(0, 2));
    bornDateArray[1]= Integer.parseInt(userInput.substring(3, 5));
    bornDateArray[2]= Integer.parseInt(userInput.substring(6, 10));
    return bornDateArray;
  }

  private Data fillDateInput()
  {
    Data bornDate = new Data(arrayBornDate()[0],arrayBornDate()[1],arrayBornDate()[2]);
    return bornDate;
  }

  private String fillEmailInput(){

    System.out.println("Type your email: ");
    userInput=keyboardInput.nextLine();

    while(!Services.validateEmail(userInput)){
      System.out.println("Invalid email, type again:");
      userInput=keyboardInput.nextLine();
    }
    return userInput;
  }
}
/*if(Services.validateRandName(fillUserNameInput())){
  name = fillUserNameInput();
}

cpfInput=fillCpfandPhoneNumberInput()[0];
phoneInput=fillCpfandPhoneNumberInput()[1];
 * 
 */

}

