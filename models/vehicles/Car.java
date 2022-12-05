package models.vehicles;

import models.types.BateryType;
import models.types.TireType;

public class Car extends Vehicle{
  
  private static String [] colorsForCar = {"red", "black", "white", "gray", "blue", "yellow", "pink"};
  private static int count = 0;

  public Car(String brand, String model, float price, int ano) {
    super(TireType.SMAL_TIRE, BateryType.CAR_BATERY, brand, model, Vehicle.getVehicleColor(colorsForCar), price, ano);
    //TODO Auto-generated constructor stub
    Car.count += 1;
  }

  public int getCarCount() {
    return Car.count;
  }

  public String toString(){
    return "Car:\n" + super.toString();
  }
}
