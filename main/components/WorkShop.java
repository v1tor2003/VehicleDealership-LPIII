package main.components;

import java.util.Scanner;

import ds.queue.Queue;
import models.types.BateryType;
import models.types.OilType;
import models.types.TireType;

public class WorkShop {
  private static Scanner input = new Scanner(System.in);
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

  private float increaseServicePriceForHeavyVehicles(float input){
    return input + (input * increaseTax);
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
