package models.parts;

import models.types.ChassisType;
import services.Services;

public class Tire extends PartBase {
  public Tire(ChassisType chassis) {
    super(Services.getTireType(chassis).partDesc(), 
          Services.getTireType(chassis).partPrice());
    //TODO Auto-generated constructor stub
  }  
}
