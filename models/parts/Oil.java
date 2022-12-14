package models.parts;

import models.types.ChassisType;
import services.Services;

public class Oil extends PartBase{
  public Oil(ChassisType chassis) {
    super(Services.getOilType(chassis).partDesc(), 
          Services.getOilType(chassis).partPrice());
    //TODO Auto-generated constructor stub
  }
}
