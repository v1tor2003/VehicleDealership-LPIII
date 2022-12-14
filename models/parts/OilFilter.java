package models.parts;

import models.types.ChassisType;
import services.Services;

public class OilFilter extends PartBase{
  public OilFilter(ChassisType chassis) {
    super(Services.getOilType(chassis).partDesc(), 
          Services.getOilType(chassis).partPrice());
    //TODO Auto-generated constructor stub
  }
}
