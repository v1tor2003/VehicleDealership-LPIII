package models.parts;

public class PartBase {
  private float price;
  private String name;

  public PartBase(String name, float price){
    this.name = name;
    this.price = price;
  }

  public float getPartPrice(){
    return this.price;
  }

  public String toString(){
    return String.format("Part Name: %s\nPart Price: $ %.2f\n", this.name, this.price);
  }

}
