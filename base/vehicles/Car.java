package base.vehicles;

import base.services.Data;
import base.types.BateryType;
import base.types.FuelType;
import base.types.TireType;

public class Car extends Vehicle{
  
  static private int TYRES_QUANTITY = 4;

  public Car(String brand, String model, String color, FuelType fuel, float price, Data fabYear) {
    super(brand, model, color, fuel, price, fabYear);
    //TODO Auto-generated constructor stub
  }
  
  public int getTire(){
    return TYRES_QUANTITY;
  }

  public FuelType getFuel(){
    return super.getVehicleFuel();
  }

  public TireType getTireType(){
    return super.getVehicleTire();
  }

  public BateryType getBateryType(){
    return super.getVehicleBatery();
  }

  @Override
  public String toString(){
    return "Car: \n" + super.toString();
  }
}
