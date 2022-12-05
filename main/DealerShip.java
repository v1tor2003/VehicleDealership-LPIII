package main;

import java.util.Scanner;

import ds.singlyll.SinglyLinkedList;
import models.vehicles.Bus;
import models.vehicles.Car;
import models.vehicles.Truck;
import models.vehicles.Van;
import models.vehicles.Motorcycle;

public class DealerShip {
  private static Scanner input = new Scanner(System.in);
  private static SinglyLinkedList<Car> cars;
  private static SinglyLinkedList<Truck> trucks;
  private static SinglyLinkedList<Bus> buses;
  private static SinglyLinkedList<Motorcycle> bikes;
  private static SinglyLinkedList<Van> vans;

  
  public static void main(String [] args) {
    cars = new SinglyLinkedList<>();
    trucks = new SinglyLinkedList<>();    
    buses = new SinglyLinkedList<>();    
    bikes = new SinglyLinkedList<>();    
    vans = new SinglyLinkedList<>();
  }
  
  private static void menu() {
    System.out.println("menu content");

    int choice = input.nextInt();

    switch(choice){
      case 0:
        break;
      case 1:
        sellVehicle();
        break;
      case 2:
        showVehiclesCount();
        break;
      case 3:
        scheduleMaintence();
      break;
    }
  }

  private static void sellVehicle(){

  }

  private static void showVehiclesCount() {
    // "Cars = "Car.getCarCount
    // "Trucks = "Truck.getCarCount 
    // "Buses = "Buses.getCarCount 
    // "Bikes = "Bikes.getCarCount 
    // "Vans = "Vans.getCarCount 
  }

}

// list vehicles , we would say, Trucks: Truck.qntd, Cars: Cars.qntd, ... 