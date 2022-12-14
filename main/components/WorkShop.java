package main.components;

import java.util.Scanner;

import ds.queue.Queue;
import models.parts.Batery;
import models.parts.Oil;
import models.parts.PartBase;
import models.parts.Tire;
import models.types.BateryType;
import models.types.ChassisType;
import models.types.MaintenceType;
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
    System.out.println(maintenceManual());

    String userInput = keyBoardInput.nextLine();

    if(userWantsToCancel(userInput)){
      System.out.println("\n<- Going Back...\n");
      return;
    }
    
    String vehicleType = userInput.substring(0, userInput.indexOf(" "));
    String serviceType = userInput.substring(userInput.indexOf(" ") + 1);
    
    while(!validateUserInput(vehicleType, serviceType)){
      System.out.println("Invalid Input, Try Again.");
      userInput = keyBoardInput.nextLine();

      if(userWantsToCancel(userInput)){
        System.out.println("\n<- Going Back...\n");
        return;
      }

      vehicleType = userInput.substring(0, userInput.indexOf(" "));
      serviceType = userInput.substring(userInput.indexOf(" "));  
    }

    PartBase partToChange = setPart(vehicleType, serviceType);

    if(!stock.hasSpecificPart(partToChange)){
      System.out.println("There Is No Parts Like This In The Stock.");
      System.out.println("If You Wanna Continue The " + partToChange.toString() + "Will Cost $ "+ partToChange.noAvailablePartTax());
      System.out.println("(Press 0 For Cancel Or Any Key To Continue.)");
      userInput = keyBoardInput.nextLine();
      
      if(userWantsToCancel(userInput)){
        System.out.println("\n<- Going Back...\n");
        return;
      }
    }

    maintenceQueue.enQueue(new Maintence((PartBase) partToChange));
  }

  private boolean userWantsToCancel(String str){
    return str.equals("0");
  }

  private String maintenceManual(){
    String str = "";

    str += "To Start A New Maintence, Enter Your Vehicle Type And Desired Service.\n";
    return str += "Such As: <Vehicle Type> <Service Name>.\n";
  }

  private PartBase setPart(String vehicleType, String serviceType){
    ChassisType chassis = Services.getChassisType(vehicleType);
    MaintenceType service = Services.getMaintenceType(serviceType);
    
    if(service == MaintenceType.BATERY_SWAP)
      return new Batery(chassis);
    else if(service == MaintenceType.OIL_CHANGE)
      return new Oil(chassis);

    return new Tire(chassis);
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
    str += "Batery Swap \t\tTire Renovation \tOil Change\n";
    str += String.format("Car/Van: $ %.2f\t$ %.2f \t\t$ %.2f\n", baterySwapService, tireRenovationService, oilChangeService);
    str += String.format("Truck/Bus: $ %.2f\t$ %.2f \t\t$ %.2f\n", increaseServicePriceForHeavyVehicles(baterySwapService), 
                                                                            increaseServicePriceForHeavyVehicles(tireRenovationService), 
                                                                            increaseServicePriceForHeavyVehicles(oilChangeService));
    str += "__________________________________________________________________\n";
    return str;
  }
  
  private String pricesOfParts(){
    String str = "";

    str += "\t\t_______ Part Price Table _______\n";
    str += "Batery \t\t\t Tire \t\t Oil\n";
    str += String.format("Car: $ %.2f \t\t$ %.2f \t $ %.2f\n", BateryType.CAR_BATERY.partPrice(), TireType.CAR_TIRE.partPrice(), OilType.OIL_GAS.partPrice());
    str += String.format("Van: $ %.2f \t\t$ %.2f \t $ %.2f\n", BateryType.STATIONARY_BATERY.partPrice(), TireType.VAN_TIRE.partPrice(), OilType.OIL_DIESEL.partPrice());
    str += String.format("Truck/Bus: $ %.2f\t$ %.2f \t$ %.2f\n", BateryType.STATIONARY_BATERY.partPrice(), TireType.TRUCK_TIRE.partPrice(), OilType.OIL_DIESEL.partPrice());
    str += "__________________________________________________________________\n";
  
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
