package models.vehicles;

import models.types.ChassisType;

public class Car extends Vehicle {

  public Car(String brand, String model, String color, float price, int fab, int km) {
    super(ChassisType.CAR_CHASSIS, brand, model, color, price, fab, km);
    //TODO Auto-generated constructor stub
  }
}
