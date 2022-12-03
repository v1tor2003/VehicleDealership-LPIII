package base.types;

public enum Optionals {
  MULTIMEDIA(1000),
  COLD_AIR(2000),
  HYDRAULIC_STEERING(5000),
  AUTOMATIC_PILOT(5000),
  AUTOMATIC_TRASMISSION(8000);

  final float optinalPrice;

  Optionals(float optinalPrice){
    this.optinalPrice = optinalPrice;
  }
}
