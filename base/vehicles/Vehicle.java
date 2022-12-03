package base.vehicles;
import base.services.Data;
import base.types.BateryType;
import base.types.FuelType;
import base.types.TireType;

public class Vehicle {
  private String brandName;
  private String modelName;
  private String color;
  private Data fabYear;
  
  private FuelType fuel;
  private TireType tire;
  private BateryType batery;
  
  private float price;
  private int maxInstallments; 
  
  final static private float FINANCIAL_ENTRANCE = 0.2f;
  static private int TYRES_QUANTITY = 1;


  public Vehicle(String brand, String model, String  color, FuelType fuel, float price, int dia, int mes, int ano){
    if(validateVehicle(brand, model, color)){
      this.brandName = brand;
      this.modelName = model;
      this.color = color;
    }

    if(validatePrice(price))
      this.price = price;
    else
      this.price = 0;

    this.fuel = fuel;
    this.fabYear = new Data(dia, mes, ano);
    this.batery = setBatery(fuel);
    this.tire = setTire();
    this.maxInstallments = calculateInstallmentsQuantity();
  }

  public Vehicle(String brand, String model, String  color, FuelType fuel, float price, Data fabYear){
    this(brand, model, color, fuel, price, fabYear.getDia(), fabYear.getMes(), fabYear.getAno());
  }

  private boolean validateNameString(String input){
    return input != null && input.length() >= 3;
  }

  private boolean validateVehicle(String brand, String model, String color){
    return validateNameString(brand) && validateNameString(model) && validateNameString(color);
  }

  private boolean validatePrice(float price){
    return price > 0;
  }

  protected float getEntrance(){
    return this.price * FINANCIAL_ENTRANCE;
  }

  protected float getEnsurancePrice(){
    return 0;
  }

  private int calculateInstallmentsQuantity(){
    return 0;
  }

  protected float getInstallmentsPrice(){
    return (float) (price - getEntrance()) / this.maxInstallments;
  }

  protected float getVehiclePrice(){
    return this.price;
  }

  protected FuelType getVehicleFuel(){
    return this.fuel;
  }

  protected TireType getVehicleTire(){
    return this.tire;
  }

  protected BateryType getVehicleBatery(){
    return this.batery;
  }

  protected String simulateFinancing(){
    return String.format("Entrance: %.2f, %dx de R$ %.2f", FINANCIAL_ENTRANCE,  this.maxInstallments, getInstallmentsPrice());
  }

  private BateryType setBatery(FuelType fuel){
    if((fuel == FuelType.DIESEL && TYRES_QUANTITY >= 4))
      return BateryType.STATIONARY_BATERY;
    
    if(TYRES_QUANTITY == 2)
      return BateryType.MOTORCICLE_BATERY;
    else
      return BateryType.CAR_BATERY;
  }

  private TireType setTire(){
    if(fuel == FuelType.DIESEL && TYRES_QUANTITY >= 6)
      return TireType.TRUCK_TIRE;
    else
      if(batery == BateryType.CAR_BATERY)
        return TireType.SMAL_TIRE;
      else
        return TireType.MOTORCICLE_TIRE;
  }

  public String toString(){
    return String.format("Brand: %s\nModel: %s\nFuel: %s\nFab Year: %s\nColor: %s\nPrice: R$ %.2f", 
                        this.brandName, this.modelName, this.fuel, this.fabYear, this.color, this.price);
  }

}
