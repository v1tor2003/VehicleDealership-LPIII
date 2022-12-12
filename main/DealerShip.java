package main;

import models.people.Customer;
import models.vehicles.Vehicle;


public class DealerShip {
  private static ShowRoom showRoom;
  private static float capital;
  private static int soldVehicles;

  public DealerShip(){
    showRoom = new ShowRoom();
    capital = 0;
    soldVehicles = 0;
  }

  public void sellVehicle(Vehicle vehicleToSell){
    if(showRoom.findInNew(vehicleToSell) || showRoom.findInUsed(vehicleToSell)){
      soldVehicles += 1;
      capital += vehicleToSell.getPrice();
      showRoom.sell(vehicleToSell);
    }else{
      System.out.println("Vehicle Not Found.");
    }
  }
  
  public void buyUsedCarFromCustomer(Customer customer){
    System.out.println("-> Buying Used Car.");

  }

  public void showRoomVehicles(){
    if(showRoom.availableVehicles() == 0)
      System.out.println("There are no vehicles in the Show Room.");  
    else
      System.out.println(showRoom.toString());
  }

  public void orderVehicle(){
  
  }

  public static String getDealerShipStatus(){
    return String.format("\n-> Status\nAvailable Vehicles: %d\nCurrent Capital: $ %.2f\nSold Vehicles: %d\n\n", 
                        showRoom.availableVehicles(), capital, soldVehicles);
  }
}

// list vehicles , we would say, Trucks: Truck.qntd, Cars: Cars.qntd, ... 


// menu
//0. exit
//1. DelaerShip
  //-ShowRoom
    //show()
    //add()

  //-Oficina
    //showQueue()
// 2. sell
  // sell car
  // sell truck
// 3. custoer
  // show()
  // add()
  // find
  // sellUsedCar()

// new Menu
// var.run()