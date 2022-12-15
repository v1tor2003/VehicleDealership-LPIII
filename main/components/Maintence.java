package main.components;

import models.parts.Batery;
import models.parts.OilFilter;
import models.parts.PartBase;
import services.StopWatch;
import services.TimeAsInt;

public class Maintence {
  final private static int jobDurationInMinutes = 2;
  private TimeAsInt startTime;
  private StopWatch cron = new StopWatch(jobDurationInMinutes, 0);
  private Thread thread0 = new Thread(cron);
  private PartBase part;
  private float servicePrice;

  public Maintence(PartBase part, float price){
    this.startTime = TimeAsInt.getCurrentTime();
    this.thread0.start();
    this.part = part;
    this.servicePrice = price;
  }

  public boolean isDone(){
    return this.cron.getCronTime() == 0;
  }

  public float getTotalCost(){
    return this.part.getPartPrice() + this.servicePrice;
  }

  private String getDetails(){
    if (part instanceof Batery)
      return "Swaping  "+this.part.getName();
    else if (part instanceof OilFilter)
      return "Changing "+this.part.getName();
    
    return "Renewing "+this.part.getName();
  }

  public String getTimeLeft(){
    return this.cron.toString();
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

  public PartBase getPart(){
    return this.part;
  }

  public String toString(){
    return String.format("\nDescription: %s\nStarted At: %s, Status: %s, Time Left: %s, Total Service Cost: $ %.2f\n", 
                          this.getDetails(), this.startTime, this.getStatusCurrentStatus(), cron.toString(),this.getTotalCost());
  }
}
