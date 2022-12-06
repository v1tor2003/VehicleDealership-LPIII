package models.vehicles;

import models.types.ChassisType;
import services.Services;

public class Vehicle {
  private String brand;
  private String model;
  private String color;
  private Integer fabricationYear;
  private Float price;
  private ChassisType vehicleType;

  public Vehicle(ChassisType vehicle, String brand, String model, String color, float price, int fab){
    if(validateVehicle(brand, model, color)){
      this.brand = brand;
      this.model = model;
      this.color = color;
    }

    if(validateFabYear(fab))
      this.fabricationYear = fab;
    else
      this.fabricationYear = 1900;

    if(validatePrice(price))
      this.price = price;
    else
      this.price = 0.0f;


    vehicleType = vehicle;
  }

  private boolean validateVehicle(String brand, String model, String color){

    return Services.validateRandName(brand) && Services.validateRandName(model) && Services.validateColor(color);
  }

  private boolean validatePrice(float price){
    return price > 0;
  }

  private boolean validateFabYear(int fabrication){
    
    return fabrication >= 1900;
  }

  private boolean isCurrentFabYearValid(){
    
    return !(this.fabricationYear == 1900);
  }

  public void setFabYear(int fabrication){
    if(!isCurrentFabYearValid())
      changeVehicleFabYear(fabrication);
    else
      System.out.println("Cannot change a valid fabYear.");
  
  } 

  private void changeVehicleFabYear(int fabrication){
    if(validateFabYear(fabrication))
      this.fabricationYear = fabrication;
    else
      System.out.println("You cannot change the year to a invalid one.");
  }

  public String toString(){
    return String.format("Type: %s\nBrand: %s\nModel: %s\nColor: %s\nFabrication Year: %d\nPrice: $%.2f\n", 
                          this.vehicleType, this.brand, this.model, this.color, this.fabricationYear, this.price);
  }
}
