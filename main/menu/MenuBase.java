package main.menu;
import java.util.Scanner;

public class MenuBase{
  private boolean exit = false;
  protected final static short exitChoice = 0;
  private static Scanner keyBoardInput = new Scanner(System.in);  
  
  public void run(String currentMenu, boolean menu, short menuOptinons){
    while(!exit){
      System.out.println(currentMenu);
      short choice = MenuBase.getChoice(menuOptinons);
      performAction(choice, menu);
    }
  }

  public void run(){
    this.run(showCurrentMenu(), false, (short) 1);
  }

  protected String showCurrentMenu(){
    return "";
  }

  protected void performAction(short option, boolean menu){
    if(option == 0){
      exit = true;
      if(menu)
        System.out.println("Exiting Programm...");
      else
        System.out.println("Going back...");
      //keyBoardInput.close();
    }
  }

  protected static short getChoice(short currentOptions){
    short currentChoice = -1;

    while(currentChoice < exitChoice || currentChoice > currentOptions){
      try{
        currentChoice = Short.parseShort(keyBoardInput.nextLine());
      }catch(NumberFormatException ex){
        System.out.printf("Invalid Choice, enter a number [0, %d].\n", currentOptions-1);
      }
    }
    return currentChoice;
  }
}
