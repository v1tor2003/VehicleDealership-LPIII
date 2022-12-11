package main.menu;

import services.Services;

public class DealerShipMenu extends MenuBase{
  private ShowRoomMenu showRoomMenu = new ShowRoomMenu();
  private MaintenceMenu maintenceMenu = new MaintenceMenu();
  private short menuOptions;
  private final static boolean isMain = false;
  private final static String [] currentMenuStringOptions = {"Select:\n", "0. Back.\n", "1. Enter ShowRoom.\n", 
                                                      "2. Enter Maintence.\n"};
  public DealerShipMenu(){
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
      showRoomMenu.run();
    else if (option == 2)
      maintenceMenu.run();
  }

  private static String showCurrentMenuDesc(){
    return "-> Entered DealerShip.";
  }

}
