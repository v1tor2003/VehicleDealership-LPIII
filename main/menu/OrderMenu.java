package main.menu;

import services.Services;

public class OrderMenu extends MenuBase{
  private short menuOptions;
  private final static boolean isMain = false;
  private final static String [] currentMenuStringOptions = {"Select:\n", "0. Back.\n", "1. Car.\n","2. Truck\n", "3. Bus\n", "4.Van\n"};
  
  public OrderMenu(){
    menuOptions = (short) (currentMenuStringOptions.length - 1);
  }

  public void run(){
    System.out.println(showCurrentMenuDesc());
    super.run(showCurrentMenu(), isMain, menuOptions);
  }

  @Override
  protected String showCurrentMenu(){
    return Services.concatenateArrayOfStrings(currentMenuStringOptions);
  }

  @Override
  protected void performAction(short option, boolean isMain){
    super.performAction(option, isMain);
    if(option == 1)
      System.out.println(showSellingCars());
    //else if (option == 2)
      //maintenceMenu.run();
  }

  private String showSellingCars(){
    String str = "";
    str += "1. Car 1\n";
    str += "2. Car 2\n";
    str += "3. Car 3\n";
    return str;
  }

  private static String showCurrentMenuDesc(){
    return "-> Entered Order Menu.";
  }
}
