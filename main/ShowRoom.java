package main;

import ds.singlyll.SinglyLinkedList;
import models.vehicles.Vehicle;

public class ShowRoom {
  private static SinglyLinkedList<Vehicle> newVehicles;
  private static SinglyLinkedList<Vehicle> usedVehicles;

  public ShowRoom(){
    newVehicles = new SinglyLinkedList<>();
    usedVehicles = new SinglyLinkedList<>();
  }

  public void add(Vehicle vehicleToAdd){
    if(vehicleToAdd.getMileage() == 0)
      newVehicles.insertAtEnd(vehicleToAdd);
    else
      usedVehicles.insertAtEnd(vehicleToAdd);
  }

  public boolean findInNew(Vehicle referenceVehicle){

    return find(referenceVehicle, newVehicles);
  }

  public boolean findInUsed(Vehicle referenceVehicle){

    return find(referenceVehicle, usedVehicles);
  }

  private boolean find(Vehicle ref, SinglyLinkedList<Vehicle> list){
    return list.contains(ref);
  }

  public void sell(Vehicle soldVehicle){
    if(soldVehicle.getMileage() == 0)
      newVehicles.remove(soldVehicle);
    else
      usedVehicles.remove(soldVehicle);
  }

  public int availableVehicles(){
    return newVehicles.size() + usedVehicles.size();
  }
}
