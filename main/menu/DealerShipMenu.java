package main.menu;

import main.DealerShip;

public class DealerShipMenu extends MenuBase{
  private ShowRoomMenu showRoomMenu;
  private MaintenceMenu maintenceMenu;

  public DealerShipMenu(DealerShip refToDealerShipObj){
    super (false, 
            new String [] {"Select:\n", "0. Back.\n", "1. Enter ShowRoom.\n", "2. Enter Maintence.\n"},
           "\n-> Entered DealerShip.\n");

    showRoomMenu = new ShowRoomMenu(refToDealerShipObj);
    maintenceMenu = new MaintenceMenu(refToDealerShipObj);
  }

  @Override
  protected void performAction(short option){
    super.performAction(option);
    if(option == 1)
      showRoomMenu.run();
    else if (option == 2)
      maintenceMenu.run();
  }
}
