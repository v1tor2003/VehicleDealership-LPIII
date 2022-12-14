package main.menu;

import main.CustomerRecords;
import services.Services;

public class CustomersMenu extends MenuBase{
  private short menuOptions;
  private  CustomerRecords refToManipulateCustomerRecords;
  private final static boolean isMain = false;
  private final static String [] currentMenuStringOptions = {"Select:\n", "0. Back.\n", "1. Register New Customer.\n","2. Delete Customer\n","3. Show All Customers\n"};

  public CustomersMenu(CustomerRecords refToCustomerRecordsObj){
    this.refToManipulateCustomerRecords=refToCustomerRecordsObj;
    menuOptions = (short) (currentMenuStringOptions.length - 1);
  }

  public void run(){
    System.out.println(showCurrentMenuDesc());
    super.run(showCurrentMenu(), isMain, menuOptions);
  }

  @Override
  protected String showCurrentMenu(){
    return Services.concatenateArrayOfStrings(currentMenuStringOptions);
  }

  @Override
  protected void performAction(short option, boolean isMain){
    super.performAction(option, isMain);
    if(option == 1)
      refToManipulateCustomerRecords.add();
    else if(option==3)
      refToManipulateCustomerRecords.showCustomers();
  }


  private static String showCurrentMenuDesc(){
    return "-> Entered Costumers Options.";
  }
}
