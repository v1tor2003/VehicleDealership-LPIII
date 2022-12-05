package models.vehicles;

import models.types.BateryType;
import models.types.TireType;

public class Vehicle {
  private TireType tire;
  private BateryType batery;
  
  private String brandName;
  private String modelName;
  private String color;
  private Integer fabYear;
  private float price; 

  private static int count;
  
  // color as rand integer, for rand = 0, color = colors[i] {red, blue, green, white}
  public Vehicle(TireType tire, BateryType batery, String brand, String model, String color, float price, int fabYear){
    
    if(validateVehicle(brand, model)){
      this.brandName = brand;
      this.modelName = model;
    }
    
    if(validatePrice(price))
      this.price = price;
    else
      this.price = 0;
    
    if(validateFabYear(fabYear))
      this.fabYear = fabYear;
    else
      this.fabYear = 0;


    this.tire = tire;
    this.batery = batery;
  }

  public static int getThisVehicleCount(Vehicle vehicle){
    return Vehicle.count;
  }

  private boolean validateFabYear(int year){
    return year >= 1900;
  }

  private boolean validateNameString(String input){
    return input != null && input.length() >= 3;
  }

  private boolean validateVehicle(String brand, String model){
    return validateNameString(brand) && validateNameString(model);
  }

  private boolean validatePrice(float price){
    return price > 0;
  }

  protected float getVehiclePrice(){
    return this.price;
  }

  protected TireType getVehicleTire(){
    return this.tire;
  }

  protected BateryType getVehicleBatery(){
    return this.batery;
  }

  protected static String getVehicleColor(String [] colors){
    final int minValue = 0;
    final int maxValue = colors.length;
    int randColor =  (int)Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
    
    return colors[randColor];
  }

  public String toString(){
    return String.format("Brand: %s\nModel: %s\nFab Year: %s\nColor: %s\nPrice: R$ %.2f", 
                        this.brandName, this.modelName, this.fabYear, this.color, this.price);
  }

}
