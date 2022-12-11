package main;

import main.menu.ApplicationMenu;

public class Main { 
  public static void main(String [] args) {
    DealerShip dealerShip = new DealerShip();
    ApplicationMenu applicationMenu = new ApplicationMenu(dealerShip);
    applicationMenu.run();
  }
}
