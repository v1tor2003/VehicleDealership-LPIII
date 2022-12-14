package main;

import main.components.CustomerRecords;
import main.components.DealerShip;
import main.menu.ApplicationMenu;

public class Main { 
  public static void main(String [] args) {
    DealerShip dealerShip = new DealerShip();
    CustomerRecords customersRecords= new CustomerRecords();
    ApplicationMenu applicationMenu = new ApplicationMenu(dealerShip, customersRecords);
    applicationMenu.run();
  }
}
