package models.types;

import models.interfaces.EnumPartsI;

public enum TireType implements EnumPartsI{
  CAR_TIRE(350, "Car"),
  VAN_TIRE(450, "Van"),
  TRUCK_TIRE(1500, "Truck");

  final float price;
  final String desc;

  TireType (float price, String desc){
    this.price = price;
    this.desc = desc;
  }

  @Override
  public float partPrice(){
    return this.price;
  }

  @Override
  public String partDesc(){
    return this.desc + "Tire";
  }

  @Override
  public String toString(){
    return this.partDesc() + this.partPrice();
  }
}
