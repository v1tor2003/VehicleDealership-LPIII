package main.menu;

import main.DealerShip;
import services.Services;

public class MaintenceMenu extends MenuBase{
  private DealerShip dealerShipRef;
  private short menuOptions;
  private final static boolean isMain = false;
  private final static String [] currentMenuStringOptions = {"Select:\n", "0. Back.\n", "1. Show Maintence Queue.\n"
                                                      , "2. Schedule Maintence\n"};
  
  public MaintenceMenu(DealerShip refToDealerShipObj){
    dealerShipRef = refToDealerShipObj;
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
    //if(option == 1)
      //TODO
    //else if (option == 2)
      //maintenceMenu.run();
  }
  private static String showCurrentMenuDesc(){
    return "-> Entered Maintence.";
  }
}
