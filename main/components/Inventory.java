package main.components;

import ds.stack.Stack;
import models.parts.Batery;
import models.parts.PartBase;
import models.parts.Tire;

public class Inventory {
  private static Stack<PartBase> bateryStock;
  private static Stack<PartBase> tireStock;
  private static Stack<PartBase> oilStock;


  public Inventory(){

  }

  public void setStartingParts(){

  }

  public boolean hasSpecificPart(PartBase ref){
    if(ref instanceof Batery) 
      return hasSpecificPart(bateryStock, ref);
    else if (ref instanceof Tire)
      return hasSpecificPart(tireStock, ref);
    else 
      return hasSpecificPart(oilStock, ref);
  }

  private boolean hasSpecificPart(Stack<PartBase> partStock, PartBase ref){
    return partStock.size() != 0 && partStock.contains(ref);
  }
}
