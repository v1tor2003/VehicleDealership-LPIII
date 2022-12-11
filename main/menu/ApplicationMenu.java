package main.menu;

import services.Services;

public class ApplicationMenu extends MenuBase{
  private DealerShipMenu dealerShipMenu = new DealerShipMenu();
  private CustomersMenu customersMenu = new CustomersMenu();
  private short menuOptions;
  private final static boolean isMain = true;
  private final static String [] mainMenuStringOptions = {"Select:\n", "0. Exit Program.\n", "1. Enter DealerShip.\n", 
                                                      "2. Customers Options.\n", "3. Show Company Status.\n"};
  public ApplicationMenu(){
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
      System.out.println("Selected: " + mainMenuStringOptions[option+1]);
  }

  private static String showGreetings(){
    String str = "";
    str += "+-------------------+\n";
    str += "|      MALLOCAR     |\n";
    str += "+-------------------+\n";

    return str;
  }
}
