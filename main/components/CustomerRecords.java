package main.components;

import java.util.Scanner;
import ds.tree.Tree;
import models.people.Customer;
import services.Services;

public class CustomerRecords
{   
    private static Tree <Customer> records;
   

    public CustomerRecords()
    {
        records=new Tree<>();
    }

    public void add()
    {
        //Customer customerToAdd= fillCustomerCredentials();
        Customer c1 = new Customer("pedro", "affonso", "05394179557", 10,11,21,"pasmarques@gmail.com", "7381191894");
        if(!records.contains(records.getRoot(),c1))
            records.insertBT(records.getRoot(), c1);
        else
        {
            System.out.println("You cannot duplicate a Customer, Try again");
        }
    }

    public void remove(Customer customer)
    {
        if(records.contains(records.getRoot(),customer))
            records.removeBT(customer);
        else
        {
            System.out.println("There is no such record.");
        }
    }

    /*
    public Customer fillCustomerCredentials()
    {
        String firstNameInput;
        String lastNameInput;
        String cpfInput;
        int dayInput;
        int monthInput; 
        int yearInput;
        String emailInput;
        String phoneInput;

        System.out.println("Insert your first Name: "+ validateUserNameInput());

        return null;
        //return new Customer(firstNameInput,lastNameInput, cpfInput, dayInput, monthInput, yearInput, emailInput, phoneInput);
    }

    private String validateUserNameInput()
    {
        Scanner keyBoardInput = new Scanner(System.in);
        String temp;
        temp = keyBoardInput.nextLine();
        
        while(!Services.validateRandName(temp))
        {
            System.out.println("Invalide name. Insert again");
            temp= keyBoardInput.nextLine();
        }
        return temp;  
    }
    */
    public void showCustomers()
    {
        records.printTree(records.getRoot());
    }

    /*
     *    private String validateUserNameInput()
    {
        Scanner keyBoardInput = new Scanner(System.in);
        String temp;
        temp = keyBoardInput.nextLine();
        
        while(!Services.validateRandName(temp))
        {
            temp= keyBoardInput.nextLine();
        }
        return temp;  
    }
    private String validateUserNameInput()
    {
        Scanner keyBoardInput = new Scanner(System.in);
        String temp;
        temp = keyBoardInput.nextLine();
        
        while(!Services.validateRandName(temp))
        {
            temp= keyBoardInput.nextLine();
        }
        return temp;  
    }
     */
 
}