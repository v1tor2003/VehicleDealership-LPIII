package models.vehicles;

import models.types.ChassisType;

public class Truck extends Vehicle {

  public Truck(String brand, String model, String color, float price, int fab, int km) {
    super(ChassisType.TRUCK_CHASSIS, brand, model, color, price, fab, km);
    //TODO Auto-generated constructor stub
  }
}