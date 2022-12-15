package main.menu;

import main.components.CustomerRecords;
import main.components.DealerShip;

public class ApplicationMenu extends MenuBase{
  private DealerShipMenu dealerShipMenu;
  private CustomersMenu customersMenu;                                             

  public ApplicationMenu(DealerShip dealerShipRef, CustomerRecords customerRef) {
    super(true, 
          new String[]{"Select:\n", "0. Exit Program.\n", "1. Enter DealerShip.\n", "2. Customers Options.\n"},
          "\n+-------------------+\n|      MALLOCAR     |\n+-------------------+\n" );

    dealerShipMenu = new DealerShipMenu(dealerShipRef);
    customersMenu = new CustomersMenu(customerRef); 
  }

  @Override
  protected void performAction(short option){
    super.performAction(option);
    if(option == 1)
      dealerShipMenu.run();
    else if (option == 2)
      customersMenu.run();
  }
}
