package models.types;

public enum TireType {
  SMAL_TIRE(350),
  TRUCK_TIRE(1500),
  MOTORCICLE_TIRE(100);

  final float tirePrice;

  TireType (float price){
    this.tirePrice = price;
  }

  public float getTirePrice(){
    return this.tirePrice;
  }
}

