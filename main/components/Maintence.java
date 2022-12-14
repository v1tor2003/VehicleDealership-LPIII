package main.components;

import models.parts.PartBase;
import services.TimeAsInt;

public class Maintence {
  private TimeAsInt startTime;
  private TimeAsInt finishTime;
  private PartBase part;
  final private static int jobDurationInMinutes = 3;

  public Maintence(PartBase part){
    this.startTime = TimeAsInt.getCurrentTime();
    this.finishTime = new TimeAsInt(TimeAsInt.addHours(startTime, 0, jobDurationInMinutes, 0));
    this.part = part;
  }

  public boolean isDone(){
    return this.startTime.equals(this.finishTime);
  }

  public String getTimeToFinish(){
    return TimeAsInt.diffTime(startTime, finishTime).toString();
  }

  public String toString(){
    return String.format("Start Time: %s, Time Left: %s\nJob: %s\n", 
                                this.startTime, TimeAsInt.diffTime(startTime, finishTime), this.part);
  }
}
