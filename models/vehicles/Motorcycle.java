package models.vehicles;

import models.types.BateryType;
import models.types.TireType;

public class Motorcycle extends Vehicle {

  private static String [] colorsForBike = {"orange", "black", "blue", "red"};
  private static int count = 0;

  public Motorcycle(String brand, String model, String color, float price, int fabYear) {
    super(TireType.MOTORCICLE_TIRE, BateryType.MOTORCYCLE_BATERY, brand, model, Vehicle.getVehicleColor(colorsForBike), price, fabYear);
    //TODO Auto-generated constructor stub
    Motorcycle.count += 1;
  }

  public int getMotorcycleCount() {
    return Motorcycle.count;
  }
  public String toString(){
    return "Bike: \n" + super.toString();
  }
}
