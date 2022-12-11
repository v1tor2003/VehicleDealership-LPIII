package services;

public class Services {
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
    final int phoneNumberSize = 10;
    
    if(phone == null || phone.length() != 10 )
      return false;
    
    boolean isEqualToANumber = false;
    final char phoneNumberAsCharArray [] = phone.toCharArray();
    final char numbersAsChar [] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    for(int i = 0; i < phoneNumberSize; i++){
      for(int j = 0; j < numbersAsChar.length; j++){
        if(phoneNumberAsCharArray[i] == numbersAsChar[j]){
          isEqualToANumber = true;
          break;
        }
      }
      if (!isEqualToANumber)
        return false;
    }

    return true;
  }
  
  public static boolean validateColor(String color){
    final String [] basicColors = {"red", "black", "white", "grey", "orange",
    "blue", "green", "yellow", "pink"};

    color.toLowerCase();

    boolean isColorValid = false;

    for(String basicColor : basicColors)
      if(color.matches(basicColor + "(.*)"))
        isColorValid = true; 

    return isColorValid;
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
}
