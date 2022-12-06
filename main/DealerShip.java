package main;

import java.util.Scanner;

import models.people.Customer;
import models.people.Person;
import models.vehicles.*;

public class DealerShip {
  private static Scanner input = new Scanner(System.in);

  public static void main(String [] args) {
    Vehicle vehicles [] = new Vehicle[4];
    vehicles[0] = new Car("Merc", "c63", "grey", 200000,2022);
    vehicles[1] = new Truck("Merc", "11-13", "blue", 30000,1985);
    vehicles[2] = new Bus("Merc", "MonoBlock", "white", 40000,1990);
    vehicles[3] = new Van("Merc", "Sprinter", "black", 50000,2010);

    Person people [] = new Person[2];
    people[0] = new Person("Vitor", "Pires", 29, 9, 2003);
    people[1] = new Customer(people[0], "vitor.pr@teste.com", "7398545529", 5000);
  
    listThings(vehicles);
    listThings(people);
  }

  private static <T> void listThings(T arr[]){
    for(T thing : arr)
      System.out.println(thing);
  }
}

// list vehicles , we would say, Trucks: Truck.qntd, Cars: Cars.qntd, ... 