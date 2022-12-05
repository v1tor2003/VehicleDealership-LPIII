package models.types;

public enum FinancingType {
  MIN_TAX(0.05f, 24),
  MID_TAX(0.1f, 48),
  MAX_TAX(0.15f, 96);

  final float taxValue;
  final int monthsToPay;

  FinancingType(float taxValue, int months){
    this.taxValue = taxValue;
    this.monthsToPay = months;
  }

  public float getTax(){
    return this.taxValue;
  }

  public int getTimeToPayInMonths(){
    return this.monthsToPay;
  }
}
