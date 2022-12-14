package main.menu;

import main.components.CustomerRecords;

public class CustomersMenu extends MenuBase{
  private CustomerRecords refToManipulateCustomerRecords;
 
  public CustomersMenu(CustomerRecords refToCustomerRecordsObj){
    super(false, 
          new String [] {"Select:\n", "0. Back.\n", "1. Register New Customer.\n","2. Delete Customer\n","3. Show All Customers\n"},
          "\n-> Entered Costumers Options.\n");
    refToManipulateCustomerRecords = refToCustomerRecordsObj;
  }

  @Override
  protected void performAction(short option){
    super.performAction(option);
    if(option == 1)
      refToManipulateCustomerRecords.add();
    else if(option==3)
      refToManipulateCustomerRecords.showCustomers();
  }
}
