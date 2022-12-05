package models.vehicles;

import models.types.BateryType;
import models.types.TireType;

public class Truck extends Vehicle {

  private static String [] colorsForTruck = {"red", "black", "white"};
  private static int count = 0;

  public Truck(String brand, String model, String color, float price, int fabYear) {
    super(TireType.TRUCK_TIRE, BateryType.STATIONARY_BATERY, brand, model, Vehicle.getVehicleColor(colorsForTruck), price, fabYear);
    //TODO Auto-generated constructor stub
    Truck.count += 1;
  }
  
  public int getTruckCount() {
    return Truck.count;
  }

  public String toString(){
    return "Truck: \n" + super.toString();
  }
  
}
