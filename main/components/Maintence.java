package main.components;

import models.parts.Batery;
import models.parts.OilFilter;
import models.parts.PartBase;
import services.TimeAsInt;

public class Maintence {
  private TimeAsInt startTime;
  private TimeAsInt finishTime;
  private PartBase part;
  final private static int jobDurationInMinutes = 3;
  private float servicePrice;

  public Maintence(PartBase part, float price){
    this.startTime = TimeAsInt.getCurrentTime();
    this.finishTime = new TimeAsInt(TimeAsInt.addHours(startTime, 0, jobDurationInMinutes, 0));
    this.part = part;
    this.servicePrice = price;
  }

  public boolean isDone(){
    return TimeAsInt.getCurrentTime().equals(this.finishTime);
  }

  public float getTotalCost(){
    return this.part.getPartPrice() + this.servicePrice;
  }

  private String getDetails(){
    if (part instanceof Batery)
      return "Swaping Batery.";
    else if (part instanceof OilFilter)
      return "Changing Oil.";
    
    return "Renewing Tires.";
  }

  public void setNewPartPrice(float newPrice){
    this.part.setPrice(newPrice);
  }

  public float getPartPrice() {
    return this.part.getPartPrice();
  }

  public String getPartName(){
    return this.part.getName();
  }

  private String getStatusCurrentStatus(){
    if(isDone())
      return "Finished";
    
    return "In Progress";
  }

  public String toString(){
    return String.format("Description: %s\nStarted At: %s, Status: %s, Total Cost: $ %.2f\n", 
                          this.getDetails(), this.startTime, this.getStatusCurrentStatus(), this.getTotalCost());
  }
}
