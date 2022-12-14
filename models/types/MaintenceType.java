package models.types;

public enum MaintenceType {
  BATERY_SWAP("batery swap"),
  OIL_CHANGE("oil change"),
  TIRE_RENEW("tire renovation");

  final String maintenceDesc;

  MaintenceType (String desc){
    this.maintenceDesc = desc;
  }

  public String getMaintenceDesc(){
    return this.maintenceDesc;
  }
}
