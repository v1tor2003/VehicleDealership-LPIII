package base.types;

public enum BateryType {
  CAR_BATERY(50, 500),
  STATIONARY_BATERY(100, 800),
  MOTORCICLE_BATERY(5, 150);

  final int amps;
  final float bateryPrice;

  BateryType (int amps, float bateryPrice){
    this.amps = amps;
    this.bateryPrice = bateryPrice;
  }

  public int getBateryCapacity(){
    return this.amps;
  }

  public String toString(){
    return String.format("Batery: %dah, price: R$ %.2f\n", this.amps, this.bateryPrice);
  }
}
