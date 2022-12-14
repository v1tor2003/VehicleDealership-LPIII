package main.menu;

import main.DealerShip;

public class ShowRoomMenu extends MenuBase{
  private DealerShip dealerShipRef;
  
  public ShowRoomMenu(DealerShip refToDealerShipObj){
    super(false, 
          new String [] {"Select:\n", "0. Back.\n", "1. Show Available Vehicles.\n", "2. Buy New Vehicle\n", "3. Buy Used Vehicle\n"},
          "\n-> Entered Show Room.\n");

    dealerShipRef = refToDealerShipObj;
  }

  @Override
  protected void performAction(short option){
    super.performAction(option);
    if(option == 1)
      dealerShipRef.showRoomVehicles();
      
    //else if (option == 2)
      //maintenceMenu.run();
  }
}
