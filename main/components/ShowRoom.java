package main.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import ds.singlyll.SinglyLinkedList;
import models.vehicles.Bus;
import models.vehicles.Car;
import models.vehicles.Truck;
import models.vehicles.Van;
import models.vehicles.Vehicle;

public class ShowRoom {
  String newVehiclesFile = new String("C:\\Users\\Pedro Affonso\\Documents\\VehicleDealership-LPIII\\services\\db\\vehicleRecord\\newVehicles.CSV");
  String usedVehiclesFile = new String("C:\\Users\\Pedro Affonso\\Documents\\VehicleDealership-LPIII\\services\\db\\vehicleRecord\\usedVehicles.CSV");

  private static SinglyLinkedList<Vehicle> newVehicles = new SinglyLinkedList<>();
  private static SinglyLinkedList<Vehicle> usedVehicles = new SinglyLinkedList<>();
 
  public ShowRoom(){
    readFromCSV(newVehiclesFile, newVehicles);
    readFromCSV(usedVehiclesFile, usedVehicles);
  }

  public void saveShowRoomRecors(){
    writeToCSV(newVehiclesFile, newVehicles);
    writeToCSV(usedVehiclesFile, usedVehicles);
  }

  public void add(Vehicle vehicleToAdd){
    if(vehicleToAdd.getMileage() == 0)
      newVehicles.insertAtEnd(vehicleToAdd);
    else
      usedVehicles.insertAtEnd(vehicleToAdd);
  }

  public int usedVehiclesQuantity(){
    return usedVehicles.size();
  }

  public int newVehiclesQuantity(){
    return newVehicles.size();
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

  public String toString(){
    return String.format("\t\tNew Vehicles:\n%s\nUsed Vehicles:\n%s\n", newVehicles, usedVehicles);
  }

  public boolean hasNewVehicle(){
    return !newVehicles.isEmpty();
  }
  public boolean hasUsedVehicle(){
    return !usedVehicles.isEmpty();
  }

  public Vehicle findOnNew(int i){
    return newVehicles.findNodeAtIndex(i).getData();
  }

  public Vehicle findOnUsed(int i){
    return usedVehicles.findNodeAtIndex(i).getData();
  }

  public String getNewVehiclesList(){
    return newVehicles.showListWithIndex();
  }

  public String getUsedVehiclesList(){
    return usedVehicles.showListWithIndex();
  }

  private static void readFromCSV(String file, SinglyLinkedList<Vehicle> list){
    String line = "";
    BufferedReader reader = null;

    try {
      reader = new BufferedReader(new FileReader(file));
      while((line = reader.readLine()) != null){
        String[] row = line.split(",");
        
        Vehicle toAdd = getVehicleToAdd(row);
        list.insertAtEnd(toAdd);
      }
    } catch (IOException e) {
      // TODO: handle exception
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  private static void writeToCSV(String file, SinglyLinkedList<Vehicle> list){
    try (PrintWriter pw = new PrintWriter(file)){
      while(!list.isEmpty())
        pw.write(formatRecord(list.removeFromStart().getData()));
    } catch (IOException e) {
      // TODO: handle exception
      e.printStackTrace();
    } 
  }

  private static String formatRecord(Vehicle obj){
    return String.format("%s,%s,%s,%s,%.2f,%d,%d\n", 
                          obj.getVehicleType(), obj.getBrandName(), obj.getModelName(),
                          obj.getColor(), obj.getPrice(), obj.getFabYear(), obj.getMileage());
  }

  private static Vehicle getVehicleToAdd(String [] row){
    if(row[0].toLowerCase().equals("car"))
      return new Car(row[1], row[2], row[3], Float.parseFloat(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
    else if(row[0].toLowerCase().equals("van"))
      return new Van(row[1], row[2], row[3], Float.parseFloat(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
    else if(row[0].toLowerCase().equals("bus"))
      return new Bus(row[1], row[2], row[3], Float.parseFloat(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
    
    return new Truck(row[1], row[2], row[3], Float.parseFloat(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
  }
}
