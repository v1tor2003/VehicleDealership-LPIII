package main.components;

import java.util.Scanner;

import ds.queue.Queue;
import models.types.BateryType;
import models.types.OilType;
import models.types.TireType;
import services.Services;

public class WorkShop {
  private static Scanner keyBoardInput = new Scanner(System.in);
  private final static int workShopSpace = 5;
  private static Inventory stock;
  private static Queue<Maintence> maintenceQueue;
  private static final float oilChangeService = 50;
  private static final float baterySwapService = 100;
  private static final float tireRenovationService = 200;
  private static final float increaseTax = 0.25f;

  public WorkShop(){
    stock = new Inventory();
    maintenceQueue = new Queue<>();
  }

  public void seeWorkFlow(){
    if(isFull())
      System.out.println("\nWorkShop Is Closed To New Jobs!");
    else if (isEmpty()){
      System.out.printf("\nWorkShop Is Open To New Jobs.\n", getFreeSpace());
      return;
    }else
      System.out.printf("\nWorkShop Is Open To %d More Maintences.\n", getFreeSpace());
    
    System.out.println("Maintence "+ maintenceQueue.toString() + "\n");
  }

  public void scheduleMaintence(){
    if(isFull() && tryFreeSpace() == null){
      System.out.printf("WorkShop Is Full, Try Again In %s\n", maintenceQueue.first().getData().getTimeToFinish());
      return;
    }
    System.out.println("0. Back.");
    System.out.println(pricesOfServices());
    System.out.println(pricesOfParts());
    // enter new maintence
    System.out.println("To Start A New Maintence, Enter Your Vehicle Type And Desired Service");
    System.out.println("Such As: <Vehicle Type> <Service Name>");
    
    String userInput = keyBoardInput.nextLine();
    if(userInput.equals("0")){
      System.out.println("<- Going Back...");
      return;
    }
    
    String vehicleType = userInput.substring(0, userInput.indexOf(" "));
    String serviceType = userInput.substring(userInput.indexOf(" "));
    
    while(!validateUserInput(vehicleType, serviceType)){
      userInput = keyBoardInput.nextLine();
      vehicleType = userInput.substring(0, userInput.indexOf(" "));
      serviceType = userInput.substring(userInput.indexOf(" "));  
    }
    // if no part in the stock, ask for continuating for more money
    // stock.respectivepart contais? if yes, we just schele
    // else we ask if the customer wants to continue
    maintenceQueue.enQueue(new Maintence(null));
  }

  private boolean validateUserInput(String vehicle, String service){

    return Services.validateVehicleType(vehicle) && Services.validateWorkShopServiceChoice(service);
  }

  private float increaseServicePriceForHeavyVehicles(float input){
    return input + (input * increaseTax);
  }

  private String pricesOfServices(){
    String str = "";
                
    str += "\t\t_______ Service Price Table _______\n";
    str += "Batery Swap \t\tTire Renovation \t\tOil Change\n";
    str += String.format("Car/Van: $ %.2f\t$ %.2f \t\t $ %.2f\n", baterySwapService, tireRenovationService, oilChangeService);
    str += String.format("Truck/Bus: $ %.2f\t$ %.2f \t\t $ %.2f\n", increaseServicePriceForHeavyVehicles(baterySwapService), 
                                                                            increaseServicePriceForHeavyVehicles(tireRenovationService), 
                                                                            increaseServicePriceForHeavyVehicles(oilChangeService));
    str += "__________________________________________________\n";
    return str;
  }
  
  private String pricesOfParts(){
    String str = "";

    str += "\t\t_______ Part Price Table _______\n";
    str += "Batery \t\tTire \t\tOil\n";
    str += String.format("Car: $ %.2f\t$ %.2f \t\t $ %.2f\n", BateryType.CAR_BATERY.partPrice(), TireType.CAR_TIRE.partPrice(), OilType.OIL_GAS.partPrice());
    str += String.format("Van: $ %.2f\t$ %.2f \t\t $ %.2f\n", BateryType.STATIONARY_BATERY.partPrice(), TireType.VAN_TIRE.partPrice(), OilType.OIL_DIESEL.partPrice());
    str += String.format("Truck/Bus: $ %.2f\t$ %.2f \t\t $ %.2f\n", BateryType.STATIONARY_BATERY.partPrice(), TireType.TRUCK_TIRE.partPrice(), OilType.OIL_DIESEL.partPrice());
    str += "__________________________________________________\n";
  
    return str;
  }

  private Maintence tryFreeSpace(){
    Maintence firstInQueue = maintenceQueue.first().getData();

    if(firstInQueue.isDone())
      return maintenceQueue.deQueue();

    return null;
  }

  private boolean hasFreeSpace(){
    return getFreeSpace() != 0;
  }

  private boolean isFull(){
    return !hasFreeSpace();
  }

  private boolean isEmpty(){
    return getFreeSpace() == 0;
  }

  private int getFreeSpace(){
    return workShopSpace - maintenceQueue.size();
  }
}
