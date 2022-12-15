package models.interfaces;

public interface PartI {
  @Override
  String toString();
  float getPartPrice();
  float noAvailablePartTax();
  void setPrice(float f);
}
