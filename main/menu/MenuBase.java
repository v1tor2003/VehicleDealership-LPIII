package main.menu;
import java.util.Scanner;

public class MenuBase{
  private boolean exit = false;
  protected final static short exitChoice = 0;
  private static Scanner keyBoardInput = new Scanner(System.in);  
  private short menuOptions;
  private boolean isMain;
  private String mainMenuStringOptions;
  private String menuDesc;

  public MenuBase(boolean isMainMenu, String [] menuOptions, String desc){
    this.menuOptions= (short) (menuOptions.length - 1);
    this.mainMenuStringOptions = setMenuOptionsAsSingleString(menuOptions);
    this.isMain = isMainMenu;
    this.menuDesc = desc;
  }

  public void run(){
    System.out.println(this.menuDesc);
    while(!exit){
      System.out.println(this.mainMenuStringOptions);
      short choice = getChoice();
      performAction(choice);
    }
  }

  private String setMenuOptionsAsSingleString(String [] menuOptions){
    String str = "";
    for (String option : menuOptions)
      str += option;
    
    return str;
  }

  protected void performAction(short option){
    if(option == 0){
      exit = true;
      if(this.isMain)
        System.out.println("\n<- Exiting Programm...\n");
      else
        System.out.println("\n<- Going back...\n");
    }
  }

  protected short getChoice(){
    short currentChoice = -1;

    while(currentChoice < exitChoice || currentChoice > this.menuOptions){
      try{
        currentChoice = Short.parseShort(keyBoardInput.nextLine());
      }catch(NumberFormatException ex){
        System.out.printf("Invalid Choice, enter a number [0, %d].\n", this.menuOptions-1);
      }
    }
    return currentChoice;
  }
}
