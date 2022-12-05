package models.vehicles;

import models.types.BateryType;
import models.types.TireType;

public class Bus extends Vehicle{

  private static String defaultColor = new String("white");
  private static int count = 0;

  public Bus(String brand, String model, float price, int fabYear) {
    super(TireType.TRUCK_TIRE, BateryType.STATIONARY_BATERY, brand, model, defaultColor, price, fabYear);
    //TODO Auto-generated constructor stub
    Bus.count += 1;
  }

  public int getBusCount() {
    return Bus.count;
  }
  
  @Override
  public String toString(){
    return "Bus: \n" + super.toString();
  }

}
