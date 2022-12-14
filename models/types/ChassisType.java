package models.types;

public enum ChassisType {
  TRUCK_CHASSIS("truck"),
  CAR_CHASSIS("car"),
  VAN_CHASSIS("van");

  final String desc;

  ChassisType (String desc){
    this.desc = desc;
  }
  
  public String getChassisDesc(){
    return this.desc;
  }
}
