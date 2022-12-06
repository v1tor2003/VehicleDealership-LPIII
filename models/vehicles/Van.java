package models.vehicles;

import models.types.ChassisType;

public class Van extends Vehicle{

  public Van(String brand, String model, String color, float price,int fab) {
    super(ChassisType.VAN_CHASSIS, brand, model, color, price, fab);
    //TODO Auto-generated constructor stub
  }

}
