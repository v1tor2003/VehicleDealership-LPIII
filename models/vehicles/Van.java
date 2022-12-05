package models.vehicles;

import models.types.BateryType;
import models.types.TireType;

public class Van extends Vehicle{

  private static String [] colorsForVan = {"white", "gray", "black"};
  private static int count = 0;

  public Van(String brand, String model, String color, float price, int fabYear) {
    super(TireType.SMAL_TIRE, BateryType.STATIONARY_BATERY, brand, model, Vehicle.getVehicleColor(colorsForVan), price, fabYear);
    //TODO Auto-generated constructor stub
    Van.count += 1;
  }

  public int getVanCount() {
    return Van.count;
  }
  
  @Override
  public String toString(){
    return "Van: \n" + super.toString();
  }
}
