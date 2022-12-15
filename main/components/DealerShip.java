package main.components;

import java.util.Scanner;
import ds.stack.Stack;
import models.vehicles.Vehicle;

public class DealerShip {
  private static Scanner keyBoardInput = new Scanner(System.in);
  private static ShowRoom showRoom;
  private static WorkShop workShop;
  private static float capital;
  private static int soldVehicles;

  public DealerShip(){
    showRoom = new ShowRoom();
    workShop = new WorkShop();
    capital = 0;
    soldVehicles = 0;
  }

  public void sellNewVehicle(){
    if(!showRoom.hasNewVehicle()){
      System.out.println("No New Vehicles Available Right Now.");
      return;
    }
    System.out.println("-> Selling New Vehicle.");
    System.out.println(showRoom.getNewVehiclesList());
    System.out.println("Select The Respective Vehicle Number:");
    int input = getVehicleToSell(showRoom.newVehiclesQuantity());
    Vehicle sold = showRoom.findOnNew(input);
    showRoom.sell(sold);
    System.out.println(String.format("Vehicle Has Been Sold: \n%s\n", sold));
  }
  
  public void sellUsedVehicle(){
    if(!showRoom.hasUsedVehicle()){
      System.out.println("No Used Vehicles Available Right Now.");
      return;
    }
    System.out.println("-> Selling Used Vehicle.");
    System.out.println(showRoom.getUsedVehiclesList());
    System.out.println("Select The Respective Vehicle Number:");
    int input =getVehicleToSell(showRoom.usedVehiclesQuantity());
    Vehicle sold = showRoom.findOnUsed(input);
    showRoom.sell(sold);
    System.out.println(String.format("Vehicle Has Been Sold: \n%s\n", sold));
  }

  private int getVehicleToSell(int size){
    int input = 0;
    boolean exit = false;

    do{
      if(keyBoardInput.hasNextInt()){
        input = keyBoardInput.nextInt();

        if(input >= 0 && input < size) exit = true;
      }else{
        System.out.println("Invalid Input, Try Again.");
        exit = false;
        keyBoardInput.next();
      }
    }while(!exit);

    return input;
  }

  public void showRoomVehicles(){
    if(showRoom.availableVehicles() == 0)
      System.out.println("There are no vehicles in the Show Room.");  
    else
      System.out.println(showRoom.toString());
  }

  public void workShopStatus(){
    workShop.seeWorkFlow();
  }

  public void createMaintence(){
    workShop.scheduleMaintence();
  }

  public static String getDealerShipStatus(){
    return String.format("\n-> Status\nAvailable Vehicles: %d\nCurrent Capital: $ %.2f\nSold Vehicles: %d\n\n", 
                        showRoom.availableVehicles(), capital, soldVehicles);
  }
}

