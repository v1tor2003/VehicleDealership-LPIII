package main.components;

import models.parts.PartBase;
import services.TimeAsInt;

public class Maintence {
  private TimeAsInt startTime;
  private TimeAsInt finishTime;
  private short inQueueId;
  private PartBase part;
  final private static int jobDurationInMinutes = 3;

  public Maintence(PartBase part){
    //this.inQueueId = Math.random()// from 1 to ;
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
    return String.format("Service Id: %d, Start Time: %s, Time Left: %s\n", this.part, this.startTime, TimeAsInt.diffTime(startTime, finishTime));
  }
}
