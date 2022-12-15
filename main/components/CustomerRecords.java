package main.components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ds.tree.Tree;
import models.people.Customer;
import services.Services;

public class CustomerRecords
{   
    private static Tree <Customer> records;
    private static Scanner keyBoardInput=new Scanner(System.in);
    private static String userInput;
  
    public CustomerRecords()
    {
        records=new Tree<>();
    }

    public void add(){
      Customer customerToAdd=fillCustomer();
      if(!records.contains(records.getRoot(),customerToAdd)){
        records.insertBT(records.getRoot(),customerToAdd);
      }
      else{
      System.out.println("You cannot duplicate a Customer, Try again");  
      }
    }

    /*
     *  public void remove()
    {
      do{
        System.out.println("Do you want cancel the registered? yes/not");
        userInput= keyBoardInput.nextLine();
        userInput.toLowerCase();
      }while((userInput!="yes")||(userInput!="not"));
      
        if(userInput=="yes"){
          System.out.println("Type your name: ");
          userInput=keyBoardInput.nextLine();
          if(records.containsKey(records.getRoot(),userInput)){
            Node<Customer> referenceToRemove= new Node<T>(userInput);

          }
         
            records.removeBT(userInput);
          else
          {
            System.out.println("There is no such record.");
          }
        }
       
    }
     */
   
  public void showCustomers()
  {
    if(records.size(records.getRoot())==0){
      System.out.println("There is no such record yet, tree is empty");
    }
    else{
      records.printTree(records.getRoot());
    }
  }

   public Customer fillCustomer(){

    String name[]=new String[2];
    String cpfAndPhone[]=new String[2];
    int bornDate[]=new int[3];
    String emailInput;

    name=fillUserNameInput();
    cpfAndPhone=fillCpfandPhoneNumberInput();
    bornDate=arrayBornDate();
    emailInput=fillEmailInput();
  
    return new Customer(name[0], name[1], cpfAndPhone[0], bornDate[0], bornDate[1], bornDate[2],  emailInput, cpfAndPhone[1]);
  }

  private String[] fillUserNameInput(){
    final String firstAndLastName[] = new String[2];
    System.out.println("Type your name in format: FirstName + LastName");
    userInput= keyBoardInput.nextLine();
    String firstName = userInput.substring(0, userInput.indexOf(" "));
    String lastName= userInput.substring(userInput.indexOf(" ") + 1);
    if(!Services.validateRandName(firstName)||!Services.validateRandName(lastName)){
      System.out.println("Type a valid name");
    }
    firstAndLastName[0]=firstName;
    firstAndLastName[1]=lastName;
    return firstAndLastName;
  }
  private String[] fillCpfandPhoneNumberInput(){
    final String arrayCpfAndNumber[] = new String[2];
    System.out.println("Type your cpf: ");
    userInput=keyBoardInput.nextLine();
    while(Services.validateCPF(userInput)){
      System.out.println("Invalid cpf, try again typing in format ###.###.###.##, without dots");
      System.out.println("Type your cpf again: ");
      //keyboardInput.close();
      userInput=keyBoardInput.nextLine();
    }
    arrayCpfAndNumber[0]=userInput;
    System.out.println("Type your phone number: ");
    userInput=keyBoardInput.nextLine();
    while(Services.validatePhoneNumber(userInput)){
    System.out.println("Invalid phone number, try again typing in format ##-#######, without -");
    System.out.println("Type your phone number again: ");
    //keyboardInput.close();
    userInput=keyBoardInput.nextLine();
    }
    arrayCpfAndNumber[1]=userInput;
    return arrayCpfAndNumber;
  }
 
  private int[] arrayBornDate(){
    final int bornDateArray[]=new int[3];
    System.out.println("Type your born date in format DD/MM/YYYY: ");
    
    userInput=keyBoardInput.nextLine();
    bornDateArray[0]= Integer.parseInt(userInput.substring(0, 2));
    bornDateArray[1]= Integer.parseInt(userInput.substring(3, 5));
    bornDateArray[2]= Integer.parseInt(userInput.substring(6, 10));
    return bornDateArray;
  
  }

  private String fillEmailInput(){
    System.out.println("Type your email: ");
    userInput=keyBoardInput.nextLine();
    while(!Services.validateEmail(userInput)){
      System.out.println("Invalid email, type again:");
      userInput=keyBoardInput.nextLine();
    }
    return userInput;
  }
}
