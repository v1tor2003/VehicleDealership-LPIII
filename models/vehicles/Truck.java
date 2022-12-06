package models.vehicles;

import models.types.ChassisType;

public class Truck extends Vehicle {

  public Truck(String brand, String model, String color, float price, int fab) {
    super(ChassisType.TRUCK_CHASSIS, brand, model, color, price, fab);
    //TODO Auto-generated constructor stub
  }
}