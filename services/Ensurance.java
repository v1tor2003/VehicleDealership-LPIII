package services;

public class Ensurance {

  private final static float BASIC = 0.1f; 
  private final static float PREMIUM = 0.25f; 

  public static float basicEnsurancePrice(float price){
    return price * BASIC;
  }

  public static float premiumEnsurancePrice(float price){
    return price * PREMIUM;
  }
}
