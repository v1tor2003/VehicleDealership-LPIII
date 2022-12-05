import javax.swing.JOptionPane;

public class Main{
  public static void main(String[] args) {
    int choice;

    do{
      choice = Integer.parseInt(JOptionPane.showInputDialog(
        baseMenuAsString()
      ));

      switch(choice){
        case 0:
          break;
        case 1:
          sellingVehilceMenu();
        case 2:
          maintenceMenu();
        case 3:
        default:
          JOptionPane.showInputDialog(null, "Invalid choice, try again");
        break;
      }

    }while(choice != 0);

  }

  private static String baseMenuAsString(){
    String str = "";
    str += "1. Sell Vehicle.\n";
    str += "2. Schedule Maintence.\n";
    str += "3. Check stock of Vehicles.\n";
    str += "4. Check parts inventory.\n";
    str += "0. Exit Programm.\n";

    return str;
  }

  private static void sellingVehilceMenu(){
    int choice;

    do{
      choice = Integer.parseInt(JOptionPane.showInputDialog(
        sellingVehilceMenuAsString()
      ));

      switch(choice){
        case 0:
          break;
        case 1:
          sellingVehilceMenu();
        case 2:
          maintenceMenu();
        case 3:
        default:
          JOptionPane.showInputDialog(null, "Invalid choice, try again");
        break;
      }

    }while(choice != 0);
  }

  private static String sellingVehilceMenuAsString(){
    String str = "";
    str += "1. Car.\n";
    str += "2. Van.\n";
    str += "3. Bus.\n";
    str += "4. Truck.\n";
    str += "4. Motorcycle.\n";
    
    return str;
  }

   private static void maintenceMenu(){
    System.out.println("1. Change Oil.");
    System.out.println("2. Change Tires.");
    System.out.println("3. Change Batery.");
    System.out.println("0. Cancel.");
  }

  static int getOption(){
    return 0;
  }
}
