package services;

import models.types.FinancingType;

public class Financing {
  private final static float ENTRANCE = 0.2f;

  public static float getEntrance(float vehiclePrice){
    return vehiclePrice * ENTRANCE;
  }

  public static float getInstallmentsPrice(float vehiclePrice, FinancingType financingType){
    return (float) vehiclePrice / financingType.getTimeToPayInMonths();
  }

  public static float getPriceWithFinancing(float vehiclePrice, FinancingType financingType){
    return vehiclePrice * financingType.getTax();
  }
}
