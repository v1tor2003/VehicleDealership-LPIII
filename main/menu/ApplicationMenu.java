package main.menu;

import main.DealerShip;
import services.Services;

public class ApplicationMenu extends MenuBase{
  private DealerShipMenu dealerShipMenu;
  private CustomersMenu customersMenu;
  private short menuOptions;
  private static boolean isMain;
  private final static String [] mainMenuStringOptions = {"Select:\n", "0. Exit Program.\n", "1. Enter DealerShip.\n", 
                                                      "2. Customers Options.\n", "3. Show Company Status.\n"};
                                                      
  public ApplicationMenu(DealerShip refToDealerShipObj){
    dealerShipMenu = new DealerShipMenu(refToDealerShipObj);
    customersMenu = new CustomersMenu(refToDealerShipObj);
    isMain = true;
    menuOptions = (short) (mainMenuStringOptions.length - 1);
  }

  public void run(){
    System.out.println(showGreetings());
    super.run(showCurrentMenu(), isMain, menuOptions);
  }

  @Override
  protected String showCurrentMenu(){
    return Services.concatenateArrayOfStrings(mainMenuStringOptions);
  }

  @Override
  protected void performAction(short option, boolean isMain){
    super.performAction(option, isMain);
    if(option == 1)
      dealerShipMenu.run();
    else if (option == 2)
      customersMenu.run();
    else if(option == 3)
      System.out.printf(DealerShip.getDealerShipStatus());
  }

  private static String showGreetings(){
    String str = "";
    str += "+-------------------+\n";
    str += "|      MALLOCAR     |\n";
    str += "+-------------------+\n";

    return str;
  }
}
