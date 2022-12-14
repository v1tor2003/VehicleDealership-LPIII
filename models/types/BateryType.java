package models.types;

import models.interfaces.EnumPartsI;

public enum BateryType implements EnumPartsI {
  CAR_BATERY(400, "Car"),
  STATIONARY_BATERY(800, "Stationary");

  final float price;
  final String desc;

  BateryType(float price, String desc){
    this.price = price;
    this.desc = desc;
  }

  @Override
  public float partPrice(){
    return this.price;
  }

  @Override
  public String partDesc(){
    return this.desc + " Batery";
  }

  @Override
  public String toString(){
    return this.partDesc() + this.partPrice();
  }
}
