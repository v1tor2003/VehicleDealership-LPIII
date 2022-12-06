package models.vehicles;

import models.types.ChassisType;

public class Car extends Vehicle {

  public Car(String brand, String model, String color, float price, int fab) {
    super(ChassisType.CAR_CHASSIS, brand, model, color, price, fab);
    //TODO Auto-generated constructor stub
  }
}
