package base.types;

public enum FuelType {
  GAS("Gas"),
  DIESEL("Diesel"),
  ALCHOOL("Alchool");

  final String fuelName;

  FuelType (String fuelName){
    this.fuelName = fuelName;
  }

  public String toString(){
    return this.fuelName;
  }
}
