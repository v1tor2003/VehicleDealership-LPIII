package models.parts;

import models.interfaces.PartI;

abstract public class PartBase implements PartI{
  private String name;
  private float partPrice;

  public PartBase(String name, float price){
    this.name = name;
    this.partPrice = price;
  }

  @Override
  public float getPartPrice(){
    return partPrice;
  }

  @Override
  public float noAvailablePartTax(){
    return this.partPrice + partPrice * 0.2f;
  }

  @Override
  public void setPrice(float newPrice){
    if(validatePrice(newPrice))
      this.partPrice = newPrice;
    else
      System.out.println("Invalid Price.");
  }

  private boolean validatePrice(float price){
    return price > 0; 
  }

  public String getName(){
    return this.name;
  }

  @Override
  public String toString(){
    return String.format("Part: %s, Price: $%.2f", this.name, this.getPartPrice());
  }
}
