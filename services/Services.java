package services;

import models.types.BateryType;
import models.types.ChassisType;
import models.types.MaintenceType;
import models.types.OilFilterType;
import models.types.TireType;

public class Services {
  private static final String [] availableVehicleType = {"car", "truck", "bus", "van"};
  private static final String [] availableWorkShopServices = {"batery swap", "tire renew", "oil change"};
  private final static int phoneSize = 11;
  private final static int cpfSize = 12;
  private final static int possibleSimpleTruckTiresQuantity [] = {6, 8, 10};

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

  public static String concatenateArrayOfStrings(String [] arr){
    String result = "";
    for(String str : arr)
      result += str;
    return result;
  }

  public static boolean isInInterval(int number, int start, int end){
    return number >= start && number <= end;
  }

  public static ChassisType getChassisType(String str){
    if(str.toLowerCase().equals("bus"))
      str = "truck";

    for(ChassisType chassis : ChassisType.values())
      if (chassis.getChassisDesc().equals(str.toLowerCase()))
        return chassis;

    return null;
  }

  public static MaintenceType getMaintenceType(String str){
    if(str.toLowerCase().equals("bus"))
      str = "truck";

    for(MaintenceType service : MaintenceType.values())
      if(service.getMaintenceDesc().equals(str.toLowerCase()))
        return service;
    
    return null;
  }

  public static OilFilterType getOilType(ChassisType chassis){
    if(chassis == ChassisType.TRUCK_CHASSIS || chassis == ChassisType.VAN_CHASSIS)
      return OilFilterType.OIL_DIESEL;
    
    return OilFilterType.OIL_GAS;
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

  public static boolean validateStringInputField(String str, String [] refArray){
    boolean isStrValid = false;

    for(String stringInArray : refArray)
      if(str.toLowerCase().equals(stringInArray))
        isStrValid = true;
  
    return isStrValid;
  }

  public static boolean validateVehicleType(String str){

    return validateStringInputField(str, availableVehicleType);
  }

  public static boolean validateWorkShopServiceChoice(String str){
    
    return validateStringInputField(str, availableWorkShopServices);
  }

  public static boolean validateTruckTiresQuantity(int input){
    for(int possibility : possibleSimpleTruckTiresQuantity)
      if(input == possibility)
        return true;
    return false;
  }

}
