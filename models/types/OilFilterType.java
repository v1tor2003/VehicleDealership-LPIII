package models.types;

import models.interfaces.EnumPartsI;

public enum OilFilterType implements EnumPartsI{
  OIL_GAS(100, "Gas Engine"),
  OIL_DIESEL(200, "Diesel Engine");

  final float price;
  final String desc;

  OilFilterType (float price, String desc){
    this.price = price;
    this.desc = desc;
  }
  @Override
  public float partPrice() {
    // TODO Auto-generated method stub
    return this.price;
  }

  @Override
  public String partDesc() {
    // TODO Auto-generated method stub
    return this.desc + " Oil Filter";
  }

  @Override
  public String toString(){
    return this.partDesc() + this.partPrice();
  }
}
