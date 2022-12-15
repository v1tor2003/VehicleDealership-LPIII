package main.components;

import java.util.Scanner;

import ds.queue.Queue;
import models.parts.Batery;
import models.parts.OilFilter;
import models.parts.PartBase;
import models.parts.Tire;
import models.types.BateryType;
import models.types.ChassisType;
import models.types.MaintenceType;
import models.types.OilFilterType;
import models.types.TireType;
import services.Services;

public class WorkShop {
  private static Scanner keyBoardInput = new Scanner(System.in);
  private final static int workShopSpace = 5;
  private final static int defaultQuantityToChange = 1;
  private static Inventory stock;
  private static Queue<Maintence> maintenceQueue;
  private static final float oilChangeService = 50;
  private static final float baterySwapService = 100;
  private static final float tireRenovationService = 200;
  private static final float notAvailablePartTax = 0.25f;

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

  private String showMaintenceInfo(){
    return "0. Back" + pricesOfServices() + pricesOfParts() + maintenceInstructions();
  }

  public void scheduleMaintence(){
    tryFreeSpace();
    if(isFull()){
      System.out.printf("WorkShop Is Full, Try Again In %s\n", maintenceQueue.first().getData().getTimeLeft());
      return;
    }

    System.out.println(showMaintenceInfo());

    String exitStringInput = "0";
    String userInputs[] = getInfo();
    String vehicleType = userInputs[0];
    String serviceType = userInputs[1];
    
    ChassisType chassis = Services.getChassisType(vehicleType);

    int partQuantityToChange = 0;
    PartBase partToChange = setPart(vehicleType, serviceType);
    float servicePrice = getServicePrice(partToChange);
    Maintence maintenceToDo = new Maintence(partToChange, servicePrice);
    float oldPrice = maintenceToDo.getPartPrice();

    if(maintenceToDo.getPart() instanceof Tire && chassis == ChassisType.TRUCK_CHASSIS)
      partQuantityToChange = getTruckTiresQuantity();
    else if(maintenceToDo.getPart() instanceof Tire && (chassis == ChassisType.VAN_CHASSIS || chassis == ChassisType.CAR_CHASSIS))
      partQuantityToChange = 4;
    else
      partQuantityToChange = defaultQuantityToChange;

    if(!stock.hasSpecificPart(partToChange)){
      maintenceToDo.setNewPartPrice(partQuantityToChange * (maintenceToDo.getPartPrice() + maintenceToDo.getPartPrice() * notAvailablePartTax));
      System.out.println("There Are No Parts Like This In The Stock.");
      System.out.println("If You Wanna Continue, The " + maintenceToDo.getPartName() + " ($"+oldPrice+") x" +partQuantityToChange + 
                          " Will Cost Now $ " + maintenceToDo.getPartPrice() + ".");
      if(getUserFinalInput().equals("0")){
        maintenceToDo = null;
        return;
      } 
    }else{
      System.out.println("Setting Up Maintence For The " + maintenceToDo.getPartName() + " ($"+maintenceToDo.getPartPrice()+") x" +partQuantityToChange + ".");
      if(getUserFinalInput().equals(exitStringInput)){
        maintenceToDo = null;
        return;
      }
    }

    maintenceQueue.enQueue(maintenceToDo);
  }

  private int getTruckTiresQuantity(){
    int tiresQuantity = 0;
    boolean exit = false;

    System.out.println("Please Inform How Many Tires Does Your Truck/Bus Have");
    do{
      if(keyBoardInput.hasNextInt()){
        tiresQuantity = keyBoardInput.nextInt();

        if(Services.validateTruckTiresQuantity(tiresQuantity)) exit = true;
      }else{
        System.out.println("Invalid Input, Try Again.");
        exit = false;
        keyBoardInput.next();
      }
    }while(!exit);

    return tiresQuantity;
  }

  private String getUserFinalInput(){
    boolean exit = false;
    String userInput = "";
    System.out.println("(Press Any Key To Confirm Or 0 To Cancel.)");
    do{
      if(keyBoardInput.hasNextLine()){
        userInput = keyBoardInput.nextLine();
        exit = true;
      }else{
        System.out.println("Invalid Input, Try Again.");
        exit = false;
        keyBoardInput.next();
      }
    }while(!exit);

    return userInput;
  }

  private String [] getInfo(){
    boolean exit = false;
    
    String userInput = "";
    String inputParts [] = {"", ""};
    
    do{
      if(keyBoardInput.hasNextLine()){
        userInput = keyBoardInput.nextLine();

        try{
          inputParts[0] = userInput.substring(0, userInput.indexOf(" "));
          inputParts[1] = userInput.substring(userInput.indexOf(" ") + 1);
        }catch(Exception e){
          System.out.println("Invalid Input, Try Again");
        }

        if(validateUserInput(inputParts[0], inputParts[1])) exit = true;
        
      }else{
        System.out.println("Invalid Input, Try Again.");
        exit = false;
        keyBoardInput.next();
      }
    }while(!exit);
    
    return inputParts;
  }

  private float getServicePrice(PartBase part){
    if(part instanceof OilFilter)
      return oilChangeService;
    else if (part instanceof Batery)
      return baterySwapService;

    return tireRenovationService;
  }

  private String maintenceInstructions(){
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
      return new OilFilter(chassis);

    return new Tire(chassis);
  }

  private boolean validateUserInput(String vehicle, String service){

    return Services.validateVehicleType(vehicle) && Services.validateWorkShopServiceChoice(service);
  }

  private float increaseServicePriceForHeavyVehicles(float input){
    return input + (input * notAvailablePartTax);
  }

  private String pricesOfServices(){
    String str = "";
                
    str += "\t\t_______ Service Price Table _______\n\n";
    str += "Batery Swap \t\tTire Renew \tOil Change\n";
    str += String.format("Car/Van: $%.2f\t$%.2f \t\t$%.2f\n", baterySwapService, tireRenovationService, oilChangeService);
    str += String.format("Truck/Bus: $%.2f\t$%.2f \t\t$%.2f\n", increaseServicePriceForHeavyVehicles(baterySwapService), 
                                                                        increaseServicePriceForHeavyVehicles(tireRenovationService), 
                                                                        increaseServicePriceForHeavyVehicles(oilChangeService));
    str += "__________________________________________________________________\n";
    return str;
  }
  
  private String pricesOfParts(){
    String str = "";

    str += "\t\t_______ Part Price Table _______\n\n";
    str += "Batery: \t\tTire: \t\t\tOil Filter:\n";
    str += String.format("Car: $%.2f \t\t$%.2f \t\t$%.2f\n", BateryType.CAR_BATERY.partPrice(), TireType.CAR_TIRE.partPrice(), OilFilterType.OIL_GAS.partPrice());
    str += String.format("Van: $%.2f \t\t$%.2f \t\t$%.2f\n", BateryType.STATIONARY_BATERY.partPrice(), TireType.VAN_TIRE.partPrice(), OilFilterType.OIL_DIESEL.partPrice());
    str += String.format("Truck/Bus: $%.2f\t$%.2f \t\t$%.2f\n", BateryType.STATIONARY_BATERY.partPrice(), TireType.TRUCK_TIRE.partPrice(), OilFilterType.OIL_DIESEL.partPrice());
    str += "__________________________________________________________________\n";
  
    return str;
  }

  private void tryFreeSpace(){
    while(!maintenceQueue.isEmpty())
      if(maintenceQueue.first().getData().isDone())
        maintenceQueue.deQueue();
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
