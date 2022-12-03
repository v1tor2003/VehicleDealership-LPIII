import base.services.Data;
import base.types.FuelType;
import base.vehicles.Car;

public class Main{
  public static void main(String[] args) {
    Data fabYear = new Data(1, 1, 1998);
   Car car = new Car("Bmw", "e36", "gray", FuelType.GAS, 2000000, fabYear);
   System.out.println(car);
   System.out.println(car.getTire());
   System.out.println(car.getBateryType());
   System.out.println(car.getFuel());

  }
}
