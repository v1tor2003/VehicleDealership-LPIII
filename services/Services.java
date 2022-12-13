package services;

public class Services {
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
