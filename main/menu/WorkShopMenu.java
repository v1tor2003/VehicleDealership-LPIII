package main.menu;

import main.components.DealerShip;

public class WorkShopMenu extends MenuBase{
  private DealerShip dealerShipRef;
  
  public WorkShopMenu(DealerShip refToDealerShipObj){
    super(false, 
          new String []{"Select:\n", "0. Back.\n", "1. Show WorkShop Status.\n", "2. Schedule Maintence\n"},
          "\n-> Entered Maintence.\n");

    dealerShipRef = refToDealerShipObj;
  }

  @Override
  protected void performAction(short option){
    super.performAction(option);
    if(option == 1)
      dealerShipRef.workShopStatus();
    else if (option == 2)
      dealerShipRef.createMaintence();
  }
}
