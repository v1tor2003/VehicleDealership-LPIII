package services;

import models.types.BateryType;
import models.types.ChassisType;
import models.types.OilType;
import models.types.TireType;

public class Services {
  private static final String [] basicColors = {"red", "black", "white", "grey", "orange",
  "blue", "green", "yellow", "pink"};
  private static final String [] availableVehicleType = {"car", "truck", "bus", "van"};
  private static final String [] availableWorkShopServices = {"batery swap", "tire renovation", "oil change"};
  final private static int phoneSize = 10;
  final private static int cpfSize = 11;

  public static boolean validateRandName(String str){
    return str != null;
  }

  public static boolean validateEmail(String email){
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if(email == null)
      return false;

    return (email.matches(regex));
  }

  public static boolean validatePhoneNumber(String phone){
    return isSequenceOfNumbers(phone, phoneSize);
  }
  public static boolean validateCPF(String cpf){
    return isSequenceOfNumbers(cpf, cpfSize);
  }
  
  public static boolean isSequenceOfNumbers(String str,int sizeFormat){
    final char strAsCharArray[]=str.toCharArray();
    if(str.length()!=sizeFormat)
      return false;
    for(int i=0;i<str.length();i++)
    {
      if(!Character.isDigit(strAsCharArray[i]))
        return false;
    }
    return true;
  }
  
  public static boolean validateColor(String color){
  
    return validateStringInputFild(color, basicColors);
  }

  public static String concatenateArrayOfStrings(String [] arr){
    String result = "";
    for(String str : arr)
      result += str;
    return result;
  }

  public static boolean isInInterval(int number, int start, int end){
    return number >= start && number <= end;
  }

  public static OilType getOilType(ChassisType chassis){
    if(chassis == ChassisType.TRUCK_CHASSIS || chassis == ChassisType.VAN_CHASSIS)
      return OilType.OIL_DIESEL;
    
    return OilType.OIL_GAS;
  }

  public static BateryType getBateryType(ChassisType chassis){
    if(chassis == ChassisType.CAR_CHASSIS)
      return BateryType.CAR_BATERY;
    
    return BateryType.STATIONARY_BATERY;
  }

  public static TireType getTireType(ChassisType chassis){
    if(chassis == ChassisType.CAR_CHASSIS)
      return TireType.CAR_TIRE;
    else if(chassis == ChassisType.VAN_CHASSIS)
      return TireType.VAN_TIRE;

    return TireType.TRUCK_TIRE;
  }

  public static boolean validateStringInputFild(String str, String [] refArray){
    str.toLowerCase();
    boolean isStrValid = false;
    
    for(String stringInArray : refArray)
      if(str.matches("(.*)" + stringInArray + "(.*)"))
        isStrValid = true;

    return isStrValid;
  }

  public static boolean validateVehicleType(String str){

    return validateStringInputFild(str, availableVehicleType);
  }

  public static boolean validateWorkShopServiceChoice(String str){
    
    return validateStringInputFild(str, availableWorkShopServices);
  }

}
