package models.parts;

import models.types.ChassisType;
import services.Services;

public class Batery extends PartBase{
  public Batery(ChassisType chassis) {
    super(Services.getBateryType(chassis).partDesc(), 
          Services.getBateryType(chassis).partPrice());
    //TODO Auto-generated constructor stub
  }
}
