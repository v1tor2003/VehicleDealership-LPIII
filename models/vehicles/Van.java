package models.vehicles;

import models.types.ChassisType;

public class Van extends Vehicle{

  public Van(String brand, String model, String color, float price, int fab, int km) {
    super(ChassisType.VAN_CHASSIS, brand, model, color, price, fab, km);
    //TODO Auto-generated constructor stub
  }

}
