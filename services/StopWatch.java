package services;

public class StopWatch implements Runnable{
  private long timeIntervalAsSeconds;
  private long cron;
  
  public StopWatch(long hours, long minutes, long seconds){
    this.timeIntervalAsSeconds =  hours * 3600 + minutes*60 + seconds;
    this.cron = 0;
  }
  
  public StopWatch(long seconds){
    this(0, seconds);
  }

  public StopWatch(long minutes, long seconds){
    this(0, minutes, seconds);
  }


  @Override
  public void run(){
    for(long i = timeIntervalAsSeconds; i >= 0; i--){
      cron = i;
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }

  public long getCronTime(){
    return this.cron;
  }

  public String toString(){
    return (new TimeAsInt(0,0, (int) getCronTime())).toString();
  }
}
